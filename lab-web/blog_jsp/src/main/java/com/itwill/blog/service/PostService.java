package com.itwill.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Post;
import com.itwill.blog.repository.PostDao;


public enum PostService {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	private final PostDao postDao = PostDao.INSTANCE;
	
	
	public List<Post> read() {
		log.debug("read()");
		return postDao.select();
	}

}
