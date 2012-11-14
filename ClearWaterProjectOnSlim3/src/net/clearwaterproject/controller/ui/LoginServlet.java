package net.clearwaterproject.controller.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import net.clearwaterproject.sys.com.Constants;
import net.clearwaterproject.sys.com.UtilString;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	          throws ServletException, IOException{
		
		//現在のURIを読み取ってリダイレクト用のコンテキストルートを用意する
		//ここでは、URLかURIか、はあえてfacebookでURI（最終的なファイル指し示す可能性）を指定しているためURIにした。
		String redirectURI = UtilString.createRedirectURI(req, "/redirect");
		
		//プロパティファイルよりappIdの取得
//		Properties prop = new Properties();
//		prop.load(this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/facebook.properties"));
//		final String appId = prop.getProperty("appId");
//		final String appId = Constants.API_KEY;

		final String url =
				"http://www.facebook.com/dialog/oauth?client_id="
				+ Constants.API_KEY
				+ "&redirect_uri="
				+ redirectURI
				+ "&scope=publish_stream";
		res.sendRedirect(url);
	}
}