package net.clearwaterproject.sys.com;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class UtilString {

	public static String createRedirectURI(HttpServletRequest req, String root)
			throws ServletException, IOException {
		StringBuffer redirectURI = req.getRequestURL();
		int index = redirectURI.lastIndexOf("/");
		redirectURI.replace(index, redirectURI.length(), "").append(root);
//		return URLEncoder.encode(redirectURI.toString(), "UTF-8");
		return redirectURI.toString();
	}
	
}
