package net.clearwaterproject.controller.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class TopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
//		//cookie情報の取得
//		String cwpUserId = CookieManager.getCWPUserId(req.getCookies());		
//		//キャッシュデータを確認
//		User user = CWPUserCashManager.getCWPUser(cwpUserId);
//		if (user == null){
//			//ユーザーデーターないのでトップ画面へ
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/top.jsp");
			rd.forward(req, res);
//		}else{
//			//ユーザーデーターあるのでマップ画面へ遷移
//    		String s = UtilString.createRedirectURI(req, "/map?fblogin=true");
//    		res.sendRedirect(UtilString.createRedirectURI(req, "/map?fblogin=true"));
//		}

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//現在地登録画面を表示する
		System.out.println("top2");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/top.jsp");
		rd.forward(req, res);
	}
	
	
}
