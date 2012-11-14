package net.clearwaterproject.controller.out;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

public class TestJsonPostAPI extends HttpServlet{
	@Override
	@SuppressWarnings("unchecked")
	protected void  doGet(HttpServletRequest req, HttpServletResponse res)
	              throws ServletException, IOException{
		List list = (List)JSON.decode(req.getInputStream());
		System.out.println(list.get(0).toString());

	}
	

}
