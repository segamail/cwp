package net.clearwaterproject.app.users;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*20120916現在web.xmlへのfilter未実装. 下記はgaeのUserServiceFactory等利用前提の記載*/
public class UserFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {}
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
//		if (userService != null && userService.isUserLoggedIn()){
//			User user = userService.getCurrentUser();
//			//多分下記のようにuserクラスをリクエストに保存しておくことで、UserService生成時にuserを取得しに行っている。
//			req.setAttribute("user", user);
//		}
		chain.doFilter(req, res);
	}

}
