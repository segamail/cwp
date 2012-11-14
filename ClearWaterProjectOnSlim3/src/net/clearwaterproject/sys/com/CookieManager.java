package net.clearwaterproject.sys.com;

import javax.servlet.http.Cookie;

public class CookieManager {
	/* Cookie関連 */
	public static final String CWP_USER = "CWP_USER";
		
	public static final String getCWPUserNo(Cookie[] cookies){
		if (cookies != null){
			for (int i=0; i < cookies.length; i++){
				if (cookies[i].getName().equals(CWP_USER)){
					return cookies[i].getValue();
				}
			}
		}
		return null;
	}
}
