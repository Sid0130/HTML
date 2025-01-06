package com.itwill.blog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.domain.Member;
import com.itwill.blog.repository.MemberDao;

public enum MemberService {
	// 싱글톤 패턴 적용
	INSTANCE;
	
	// 데이터 베이스 접근을 위한 MemberDao 메서드 객체 생성(싱글톤)
	private final MemberDao memberDao = MemberDao.INSTANCE;
	
	// 디버그 로그 출력을 위한 객체 생성
	private static final Logger log = LoggerFactory.getLogger(MemberDao.class);
	
	// 로그인 서비스
	public Member signin(String username, String password) {
		
		Member member = memberDao.select(username, password);
		
		return member;
	}

}
