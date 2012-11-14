package net.clearwaterproject.controller.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.PersistenceManager;

import org.datanucleus.sco.backed.List;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;

import net.clearwaterproject.db.dao.jdo.PMF;
import net.clearwaterproject.sys.com.ComDateFormat;


@SuppressWarnings("serial")
public class InputCheckWaterInfoServlet extends HttpServlet{
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		//現在地登録画面を記載する。この情報を元に画面上の住所場所を取得している。
		req.setAttribute("lat", req.getParameter("lat"));
		req.setAttribute("lng", req.getParameter("lng"));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/inputCheckWaterInfo.jsp");
		rd.forward(req, res);
	}
	
}
