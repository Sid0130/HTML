package com.itwill.blog.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpFilter {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// 자식 클래스 선언
		HttpServletRequest req = (HttpServletRequest) request; // 다형성
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 컨택스트 패스 확인
		String reqUrl = req.getRequestURL().toString(); // 스트링타입 버퍼로 toString으로 변환
		log.debug("request URL = {}",reqUrl); // URL 패스 경로
		
		
		String reqUri = req.getRequestURI(); 
		log.debug("request URI = {}",reqUri); // URI 패스 경로
		
		String contextPath = req.getContextPath();
		log.debug("request ContextPath = {}",contextPath); // ContextPath 패스 경로
		
		String qs = req.getQueryString(); // QueryString 패스 경로
		log.debug("request QueryString = {}",qs);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
