package com.itwill.blog.web.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.service.PostService;

/**
 * Servlet implementation class PostPaginationController
 */
@WebServlet(name = "postPaginationController", urlPatterns = { "/post/pagination" })
public class PostPaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostPaginationController.class);
	private final PostService postService = PostService.INSTANCE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPaginationController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	// 리퀘스트 요청 파라미터를 읽음
    	String category = request.getParameter("category");
    	String keyword = request.getParameter("keyword");
    	String page_ = request.getParameter("page");
    	log.debug("doGet(category={}, keyword={})", category,keyword);
    	
    	if(keyword != null && !keyword.equals("")) {
    		keyword = keyword;
    	}
    		
    	if(category != null && !category.equals("")) {
    		category = category;
    	}
    	
    	int page = 1;
    	if(page_ != null)
    		page = Integer.parseInt(page_);
    	
    	
    	
    	List<Post> post = postService.read(category, keyword, page);
    	
    	request.setAttribute("posts", post);
    	
    	
    	request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
	}

}
