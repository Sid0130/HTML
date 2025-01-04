package com.itwill.blog.web.post;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostListController
 */
@WebServlet(name = "postListController", urlPatterns = { "/post/list" })
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 디버그 로그 출력을 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostListController.class);
	
	// 게시물 목록 데이터를 처리하는 비지니스 로직 서비스 객체 (싱글톤 패턴)
	private final PostService postService = PostService.INSTANCE;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListController() { // 기본 생성자
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	// 디버그 로그: doGet 메서드 호출 확인
    	log.debug("doGet()"); 
    	
    	// 게시물 목록 데이터를 조회
    	List<Post> post = postService.read(); 
    	
    	// 조회된 게시물 목록을 요청 속성에 추가
    	request.setAttribute("posts", post); 
    	
    	// 서버에서 list.jsp로 요청 전달
    	request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
	}

}
