package net.clearwaterproject.sys.com;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter{
  private String encoding = null;
  
  public void init(FilterConfig config) throws ServletException{
	  //web-xmlの<init-param>のparam-name=encoding　の文字コードに変換
	  encoding = config.getInitParameter("encoding");
  }
  
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
     throws ServletException, IOException{
	  
	  req.setCharacterEncoding(encoding);
	  chain.doFilter(req,res);
  }
  
  public void destroy(){
	  encoding = null;
  }
}
