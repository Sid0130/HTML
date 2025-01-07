package com.itwill.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.repository.PostDao;

// 비지니스 객체 PostService
public enum PostService {
	// 싱글톤 패턴 적용
	INSTANCE;
	
	// 디버그 로그를 출력하기 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	// 데이터베이스 접근을 위한 postDao 싱글톤 객체.
	private final PostDao postDao = PostDao.INSTANCE;
	
	// 데이터베이스에서 게시물 목록을 조회.
	public List<Post> read() {
		log.debug("read()"); // read() 메서드 호출 확인
		return postDao.select(); 
	}
	
	// 데이터베이스에 게시물을 생성
	public int create(Post post) {
		log.debug("create({})", post); // 생성된 데이터 로그 확인
		
		int result = postDao.insert(post); // 데이터베이스에 insert 메서드 호출
		
		return result;
	} 
	
	// 데이터베이스에서 게시물을 조회
	public Post read(Integer id) {
		log.debug("read(id= {})", id); // 조회한 아이디를 로그 확인
		
		// 데이터 베이스에 조회한 id 데이터를 post 객체에 할당 
		Post post = postDao.select(id); 
		
		return post;
	}
	
	// 데이터베이스에 게시물을 수정 
	public int update(Post post) {
		// 업데이트한 결과를 로그에 출력
		log.debug("update(post={})",post);
		
		// 데이터베이스에 업데이트된 게시물 호출.
		int result = postDao.update(post);
		log.debug("{}개 행이 업데이트됨", result);
		
		return result;
	}
	
	public int delete(Integer id) {
		
		// 데이터베이스에 삭제한 게시물 호출
		int result = postDao.delete(id);
		log.debug("{}개 행이 삭제됨", result);
		
		
		return result;
	}
	
}