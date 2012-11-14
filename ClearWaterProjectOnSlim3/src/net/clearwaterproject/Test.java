package net.clearwaterproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*　テスト実施用サーブレット */
@SuppressWarnings("serial")
public class Test extends HttpServlet{
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//現在地登録画面を表示する
		System.out.println("test1");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/test.jsp");
		rd.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//現在地登録画面を表示する
		System.out.println(req.getParameter("comment"));
		System.out.println("test2");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/test.jsp");
		rd.forward(req, res);
	}
	
	

}
