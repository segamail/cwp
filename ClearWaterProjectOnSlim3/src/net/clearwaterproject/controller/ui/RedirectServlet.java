package net.clearwaterproject.controller.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.users.UserService;
import net.clearwaterproject.app.users.UserServiceFactory;
import net.clearwaterproject.model.User;
import net.clearwaterproject.sys.com.Constants;
import net.clearwaterproject.sys.com.CookieManager;
import net.clearwaterproject.sys.com.MemCacheString;
import net.clearwaterproject.sys.com.UtilString;

import com.restfb.FacebookClient;

import org.slim3.memcache.Memcache;

@SuppressWarnings("serial")
public class RedirectServlet extends HttpServlet {

	private FacebookClient facebookClient;
	
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        /*
         * アクセストークンの取得
         */
    	final String code = req.getParameter("code");
    	//コード取得出来ない場合、アプリ許可をもらっていないため元のトップ画面に戻る
    	if (code == null){
    		res.sendRedirect(UtilString.createRedirectURI(req, "/top"));
    	}else{
    	    long top1 = System.nanoTime();
    		//取得出来た場合、アクセストークンの取得
    		String accessToken = accessFBData(req,res,code);
    		
    		long top2 = System.nanoTime();
    		//ユーザーデータの取得
    		Map map = getFBUserData(req,res,accessToken);
    		
    		long top3 = System.nanoTime();
    		//とりあえずはjdoからユーザーデータ取得。しかしここはそもそものユーザーセッション管理方法を検討すべし　20120916
    		UserService us = UserServiceFactory.getUserService();
    		User loginUser = us.getLoginUserByFB(req, map.get("facebook_id").toString());
    		
    		long top4 = System.nanoTime();
    		if(loginUser == null){
    			//CWPに初回ログイン(キャッシュ無、userデータ無し)であれば、CWPにFBのデータを登録し、改めて取得
    		    us.setUser(map);
    			loginUser = us.getUser();
    		} //CWPに初回ログインでなければそのまま次へ
    		
    		long top5 = System.nanoTime();
    		//キャッシュに登録
    		Memcache.put(loginUser.getCwp_user_no(), loginUser);
    		
    		//CookieにCWPユーザーID情報を設定
    		Cookie cookie = new Cookie( CookieManager.CWP_USER, loginUser.getCwp_user_no() );
    		res.addCookie(cookie);
    		
    		long top6 = System.nanoTime();
    		
    		//mapへ
    		String s = UtilString.createRedirectURI(req, "/map?fblogin=true");
    		res.sendRedirect(UtilString.createRedirectURI(req, "/map?fblogin=true"));
//    		
//    		System.out.println("top2-1:"+(top2-top1)/1000000);
//    		System.out.println("top3-2:"+(top3-top2)/1000000);
//    		System.out.println("top4-3:"+(top4-top3)/1000000);
//    		System.out.println("top5-4:"+(top5-top4)/1000000);
//    		System.out.println("top6-5:"+(top6-top5)/1000000);
    		
    	}
    }

    private String accessFBData(HttpServletRequest req, HttpServletResponse res, String code)            
    		throws ServletException, IOException {
    	final String callbackURL = req.getRequestURL().toString(); //
    	final String accessTokenURL = 
    			Constants.OPEN_GRAPH + "oauth/access_token?client_id="
    					+ Constants.API_KEY
    					+ "&redirect_uri="
    					+ URLEncoder.encode(callbackURL, "UTF-8")
    					+ "&client_secret="
    					+ Constants.APP_SECRET
    					+ "&code="
    					+ URLEncoder.encode(code, "UTF-8");
    	final String accessTokenResult = httpRequest(new URL(accessTokenURL));

    	//結果のパース
    	String accessToken = null;
    	String[] pairs = accessTokenResult.split("&");
    	for (String pair : pairs){
    		String[] kv = pair.split("=");
    		if (kv.length != 2){
    			throw new RuntimeException("Unexpected auth response");
    		} else {
    			if (("access_token").equals(kv[0])){
    				accessToken = kv[1];
    			}
    		}
    	}
    	return accessToken;
    }

    private Map getFBUserData(HttpServletRequest req, HttpServletResponse res, String accessToken)            
    		throws ServletException, IOException {
    	/*
    	 * APIの実行
    	 */
    	final String apiURL = 
    			Constants.OPEN_GRAPH + "me?access_token=" +URLEncoder.encode(accessToken,"UTF-8");
    	final String apiResult = httpRequest(new URL(apiURL));
    	Map me = (Map) JSON.decode(apiResult);   	

    	/*
    	 * ログイン処理
    	 */
    	Map map = new HashMap();
    	map.put("service", "Facebook");
    	map.put("facebook_id", String.valueOf(me.get("id")));
    	map.put("name", String.valueOf(me.get("name")));
    	map.put("first_name", String.valueOf(me.get("first_name")));
    	map.put("last_name", String.valueOf(me.get("last_name")));
    	map.put("middle_name", String.valueOf(me.get("middle_name")));
    	map.put("gender", String.valueOf(me.get("gender")));
    	map.put("email", String.valueOf(me.get("email")));
    	map.put("picture", Constants.OPEN_GRAPH + String.valueOf(me.get("id")) +"/picture");
    	map.put("accessToken", accessToken);

    	return map;

    }


    String httpRequest(URL url) throws IOException {
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.setDoOutput(true);
    	conn.setUseCaches(false);
    	conn.setRequestMethod("GET");
    	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	String line = null;
    	String response = "";
    	while ((line = reader.readLine()) != null) {
    		response += line;
    	}
    	reader.close();
    	conn.disconnect();
    	return response;
    }

}