package com.itwill.blog.web.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.service.PostService;

/**
 * Servlet implementation class PostUpdateController
 */
@WebServlet(name = "postUpdateController", urlPatterns = { "/post/update" })
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 50
	)
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 디버그 로그 출력을 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostUpdateController.class);
	
	// 비지니스 로직을 처리하는 서비스 객체 생성 (싱글톤 패턴)
	private final PostService postService = PostService.INSTANCE;      
	
	private static final String UPLOAD_DIRECTORY = "C:/Github/HTML/lab-web/blog_jsp/src/main/webapp/static/file";
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
    	String filePath = request.getParameter("files");
    	
    	// 새 파일 업로드
    	Part filePart = request.getPart("files");
    	// 업로드된 파일 이름을 읽고
    	String uploadedFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
    	String uploadDirectory = UPLOAD_DIRECTORY;
    	
    	// "C:/java157/tool/git/HTML/lab-web/blog_jsp/src/main/webapp/static/file";
    	// "C:/Github/HTML/lab-web/blog_jsp/src/main/webapp/static/file";
    	
    	File uploadDir = new File(uploadDirectory);
    	if(!uploadDir.exists()) {
    		uploadDir.mkdir(); // 업로드 디렉토리가 없을 시 생성.
    	}
    	
    	String newFilePath = null;

    	if (uploadedFileName != null && !uploadedFileName.isEmpty()) {
    	    // 새 파일이 업로드된 경우
    	    newFilePath = uploadDirectory + File.separator + uploadedFileName;
    	    filePart.write(newFilePath);

    	    // 기존 파일 삭제
    	    if (filePath != null && !filePath.isEmpty()) {
    	        File oldFile = new File(filePath);
    	        if (oldFile.exists()) {
    	            oldFile.delete();
    	        }
    	    }
    	} else {
    	    // 새 파일이 없으면 기존 파일 경로 유지
    	    newFilePath = filePath;
    	    log.debug("No new file uploaded. Retaining existing file: {}", filePath);
    	}
    	
    	// 포스트 객체 생성 및 빌더패턴 적용
    	Post post = Post.bulider()
    			.id(id)
    			.title(title)
    			.content(content)
    			.files(newFilePath)
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
