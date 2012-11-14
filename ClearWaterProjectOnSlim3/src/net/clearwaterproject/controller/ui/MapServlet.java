package net.clearwaterproject.controller.ui;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.users.LoginUser;
import net.clearwaterproject.sys.com.CWPUserCashManager;
import net.clearwaterproject.sys.com.CookieManager;
import net.clearwaterproject.sys.com.UtilString;

@SuppressWarnings("serial")
public class MapServlet extends HttpServlet{
	
	private boolean fbLoginStatus    = true;
	private boolean chkCWPLoginFirst = false;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
//		//cookie情報の取得
//		String cwpUserId = CookieManager.getCWPUserId(req.getCookies());		
//		//キャッシュにユーザーデータあるか確認
//		User user = CWPUserCashManager.getCWPUser(cwpUserId);
//		
//		if (user != null){
//			//キャッシュにユーザーが入っている＝CWPログインしている場合
//			//CWPに初回ログインかどうかの確認
//			UserJO loginUser = new UserJO(user);
//
//			/* 検索結果をJavaオブジェクトをJSONに変更してブラウザに返す  */
//			HashMap map = new HashMap();
//			map.put("loginuser",loginUser);
//			JSON.encode(map, res.getOutputStream());
			//地図画面を表示する
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/map.jsp");
			rd.forward(req,res);
//		} else {
//			//CWPにログインしていない場合、top画面に戻る
//			res.sendRedirect(UtilString.createRedirectURI(req, "/top"));
////			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/top.jsp");
////			rd.forward(req,res);
//		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//FBにログインしているかどうかの確認
		LoginUser loginUser = (LoginUser)req.getAttribute("user");
		String fblogin = (String)req.getParameter("fblogin");
		if(("true").equals(fblogin)){fbLoginStatus = true;}
		if (fbLoginStatus){
			//ログインしている場合
			//CWPに初回ログインかどうかの確認
			//facebookIdを取得
			//cwpにユーザー情報をfacebookIdを元に取得??(20120901LoginUserにUserの継承をさせる？)
//			new LoginUser(facebookId);
			if(!chkCWPLoginFirst){
			//CWPに初回ログインであれば、CWPにFBのデータを登録
			} else {
			//CWPに初回ログインでなければ、そのままユーザー情報を取得
			}
			//地図画面を表示する
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/map.jsp");
			rd.forward(req,res);
		} else {
			//FBにログインしていない場合、top画面に戻る
			res.sendRedirect(UtilString.createRedirectURI(req, "/top"));
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/top.jsp");
//			rd.forward(req,res);
		}
		
	}
}
