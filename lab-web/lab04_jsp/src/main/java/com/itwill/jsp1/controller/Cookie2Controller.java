package com.itwill.jsp1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Cookie2Controller
 */
@WebServlet(name = "cookie2Controller", urlPatterns = { "/cookie2" })
public class Cookie2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie2Controller() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cookie2Controller::doGet() 호출");
		
		Cookie cookie = new Cookie("hi", "안녕");
		response.addCookie(cookie); // 응답으로 쿠키를 주는것
		
		
		int count = 1;
		
		//쿠키를 배열에 담아서
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			System.out.println(c.getName() + " - " + c.getValue());
		}
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/cookie2.jsp").forward(request, response);
		// html을 만들어서 뷰에 그려주는 jsp파일 경로를 작성 전달.
		
		
	}

}
