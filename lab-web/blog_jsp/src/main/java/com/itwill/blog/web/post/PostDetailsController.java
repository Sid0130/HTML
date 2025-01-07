package com.itwill.blog.web.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.service.PostService;

/**
 * Servlet implementation class PostDetailsController
 */
@WebServlet(name = "postDetailsController", urlPatterns = { "/post/details" })
public class PostDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 디버그 로그 출력을 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostDetailsController.class);
       
	// 비지니스 로직을 처리하는 서비스 객체 생성 (싱글톤 패턴)
	private final PostService postService = PostService.INSTANCE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDetailsController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	// 디버그 출력: doGet메서드 호출 확인
    	log.debug("doGet()");
    	
    	// 요청 파라미터 아이디를 읽음.
    	Integer id = Integer.parseInt(request.getParameter("id")) ;
    	
    	// 서비스 계층의 아이디를 호출. 아이디로 글 상세정보를 가져옴
    	Post post = postService.read(id);
    	
    	// 조회된 게시물 상세 정보를 요청 속성에 추가. jsp에 사용
    	request.setAttribute("post", post); 
    	
    	// 서버에서 details.jsp로 요청 전달
    	request.getRequestDispatcher("/WEB-INF/views/post/details.jsp").forward(request, response);
	}

}