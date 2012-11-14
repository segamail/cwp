package net.clearwaterproject.controller.out;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.users.UserService;
import net.clearwaterproject.app.users.UserServiceFactory;
import net.clearwaterproject.meta.UserMeta;
import net.clearwaterproject.model.User;
import net.clearwaterproject.sys.com.CWPUserCashManager;
import net.clearwaterproject.sys.com.CookieManager;
import net.clearwaterproject.sys.com.MemCacheString;

/*
 * ログイン時にfacebook_idをPOST受信し、そのIDに該当するCWPユーザー情報をJSON形式で返すサーブレットクラス
 */
public class UserJsonServlet  extends HttpServlet{

	private static final long serialVersionUID = 2612440668813438004L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
		res.setContentType("application/json; charset=UTF-8");
		//キャッシュからユーザー取得。なければ送られてきたfacebook_idから取得。
		UserService us = UserServiceFactory.getUserService();
		User user = us.getLoginUserByFB(req, (String) req.getAttribute("facebook_id"));
		//jsonデータ出力用map
        Map map = new HashMap();    
//		long r1 = Runtime.getRuntime().freeMemory();
        String userSt = UserMeta.get().modelToJson(user,3);
        map.put("loginUser",JSON.decode(userSt));
        
//        long r2 = Runtime.getRuntime().freeMemory();

//        //もし上記でもユーザーデータが取れていない場合の措置。ログインしていないゲスト利用者の場合はjsonデータなし。
//      if (user != null){
//          UserJO u = new UserJO(user);
//          map.put("loginUser2",u);
//      }else{
//          map.put("loginUser2",null);
//      }
      
//		long r3 = Runtime.getRuntime().freeMemory();
//		System.out.println("r1-r2:"+(r1-r2));
//		System.out.println("r2-r3:"+(r2-r3));

        
		JSON.encode(map,res.getOutputStream());
		
	}
}
