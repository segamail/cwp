package net.clearwaterproject.controller.ui;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.clearwaterproject.app.promoter.PromoterService;
import net.clearwaterproject.app.users.LoginUser;
import net.clearwaterproject.sys.com.UtilString;

/*
 * 事業者登録に飛ばす画面
 */
@SuppressWarnings("serial")
public class RegistPromoterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//top画面から飛ばして事業者登録フォームを提示
//		res.sendRedirect("/WEB-INF/registPromoter.jsp");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/registPromoter.jsp");
		rd.forward(req,res);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//事業者データのインデックス受け取り
		String email = (String)req.getParameter("org_email");
		//そもそもemail入っていなければエラー
		if (email == null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/registPromoter.jsp");
			rd.forward(req,res);
			return;
		}
		
		PromoterService prmService = new PromoterService();
		//事業者データがなければデータ詳細受け取り
		if (prmService.getPromoter(email) == null){
			HashMap map = new HashMap();
			map.put("org_name", (String)req.getParameter("org_name"));
			map.put("org_name_kn", (String)req.getParameter("org_name_kn"));
			map.put("post", (String)req.getParameter("post"));
			map.put("address", (String)req.getParameter("address"));
			map.put("sector", (String)req.getParameter("sector"));
			map.put("org_detail", (String)req.getParameter("org_detail"));
			map.put("ir_no", (String)req.getParameter("ir_no"));
			map.put("founding_date", (String)req.getParameter("founding_date"));
			map.put("tel", (String)req.getParameter("tel"));
			map.put("fax", (String)req.getParameter("fax"));
			map.put("org_email", (String)req.getParameter("org_email"));
			map.put("url", (String)req.getParameter("url"));
			//登録
			prmService.setPromoter(map);
		}
		//事業者メンバー登録画面へ
		req.setAttribute("org_name",(String)req.getParameter("org_name"));
		req.setAttribute("org_email",(String)req.getParameter("org_email"));
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/registPromoterMember.jsp");
	    rd.forward(req, res);
//		res.sendRedirect(UtilString.createRedirectURI(req, "/registpromotermember"));		

	}
}
