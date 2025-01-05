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
 * Servlet implementation class PostUpdateController
 */
@WebServlet(name = "postUpdateController", urlPatterns = { "/post/update" })
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 디버그 로그 출력을 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostUpdateController.class);
	
	// 비지니스 로직을 처리하는 서비스 객체 생성 (싱글톤 패턴)
	private final PostService postService = PostService.INSTANCE;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateController() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	// 양식 데이터를 읽음
    	Integer id = Integer.parseInt(request.getParameter("id"));
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	
    	// 포스트 객체 생성 및 빌더패턴 적용
    	Post post = Post.bulider()
    			.id(id)
    			.title(title)
    			.content(content)
    			.build();
    	
    	// post에 할당된 데이터 로그 출력
    	log.debug("doPost(post= {})", post);
    			
    	// 게시물 수정 로직
    	postService.update(post);
    	
    	// 수정 후 지정된 경로로 이동
    	String url = request.getContextPath() + "/post/list";
    	response.sendRedirect(url);
	}

}
