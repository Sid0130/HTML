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
import com.itwill.blog.domain.Post.PostBuilder;
import com.itwill.blog.service.PostService;

/**
 * Servlet implementation class PostCreateConteroller
 */
@WebServlet(name = "postCreateConteroller", urlPatterns = { "/post/create" })
public class PostCreateConteroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//디버그 로그 출력
	private static final Logger log = LoggerFactory.getLogger(PostCreateConteroller.class);
	
	// 비지니스 로직을 처리하는 서비스 객체 (싱글톤 패턴)
	private final PostService postService = PostService.INSTANCE;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCreateConteroller() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	// 서버에서 create.jsp로 요청 전달
    	request.getRequestDispatcher("/WEB-INF/views/post/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	// post 디버그 출력.
    	log.debug("doPost()");
    	
    	// 새 글 작성의 데이터 요청 파라미터 읽기
    	String title = request.getParameter("title"); // 제목 읽기
    	String content = request.getParameter("content"); // 내용 읽기
    	String author = request.getParameter("author"); // 작성자 읽기
    	
    	// 포스트 객체를 생성하기 위한 빌더 패턴
    	// 빌더를 통해 Post 객체의 title, content, author 필드를 설정하고 생성.
    	Post post = Post.bulider() 
    			.title(title) 		// 게시물 제목 설정
    			.content(content)   // 게시물 내용 설정
    			.author(author)     // 작성자 설정
    			.build();			// 설정한 값으로 post 객체 생성
    	
    	// 요청 데이터로 게시물을 생성하는 비지니스 로직 호출
    	postService.create(post);
    	
    	// 게시물 생성 후 게시물 목록 페이지로 리다이렉트
    	String url = request.getContextPath() + "/post/list"; // 응답 URL 생성
    	response.sendRedirect(url); // 클라이언트를 목록 페이지로 리다이렉트
	}

}
