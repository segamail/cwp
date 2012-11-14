package net.clearwaterproject.controller.ui;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.clearwaterproject.app.promoter.PromoterMemberService;
import net.clearwaterproject.app.promoter.PromoterService;
import net.clearwaterproject.app.users.LoginUser;
import net.clearwaterproject.sys.com.UtilString;

/*
 * 事業者登録に飛ばす画面
 */
@SuppressWarnings("serial")
public class RegistPromoterMemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//事業者メンバー登録フォームを提示
//		res.sendRedirect("/WEB-INF/registPromoter.jsp");
		req.setAttribute("org_name", req.getAttribute("org_name"));
		req.setAttribute("org_email", req.getAttribute("org_email"));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/registPromoterMember.jsp");
		rd.forward(req,res);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//事業者メンバーデータのインデックス受け取り
		String email = (String)req.getParameter("email");
		//そもそもemail入っていなければエラー
		if (email == null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/registPromoterMember.jsp");
			rd.forward(req,res);
			return;
		}
		
		PromoterMemberService prmMemberService = new PromoterMemberService();
		//事業者メンバーデータがなければデータ詳細受け取り
		if (prmMemberService.getPromoterMember(email) == null){
			HashMap map = new HashMap();
			map.put("org_email", (String)req.getParameter("org_email"));
			map.put("last_name", (String)req.getParameter("last_name"));
			map.put("last_name_kn", (String)req.getParameter("last_name_kn"));
			map.put("first_name", (String)req.getParameter("first_name"));
			map.put("first_name_kn", (String)req.getParameter("first_name_kn"));
			map.put("gender", (String)req.getParameter("gender"));
			map.put("department", (String)req.getParameter("department"));
			map.put("phone", (String)req.getParameter("phone"));
			map.put("mobile_phone", (String)req.getParameter("mobile_phone"));
			map.put("email", (String)req.getParameter("email"));
			map.put("mobile_email", (String)req.getParameter("mobile_email"));
			//事業者データを取得してListにメンバー登録追加
			prmMemberService.setPromoterMember(map);
		}
		//マップ画面へ
		res.sendRedirect(UtilString.createRedirectURI(req, "/map"));		

	}
}
