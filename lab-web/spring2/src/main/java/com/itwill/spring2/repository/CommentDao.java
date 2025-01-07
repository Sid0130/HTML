package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Comment;

public interface CommentDao {
	// 댓글의 목록을 검색하는 sql
	List<Comment> selectByPostId(Integer postId); 
}
