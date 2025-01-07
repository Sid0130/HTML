package com.itwill.blog.repository;

import static com.itwill.blog.datasourceutil.DataSourceUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.datasourceutil.DataSourceUtil;
import com.itwill.blog.domain.Member;
import com.zaxxer.hikari.HikariDataSource;

public enum MemberDao {
	INSTANCE;
	
	// 디버그 로그를 출력하기 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(MemberDao.class);
	// HikariCP를 사용한 데이터베이스 커넥션 풀 객체 생성
	private final HikariDataSource ds = DataSourceUtil.INSTANCE.getDataSource();
	
	
	private static final String SQL_SELECT_BY_USERNAME_AND_PASSWORD =
			"select * from members where username = ? and password = ?";
	
		public Member select(String username, String password) {
			
		log.debug(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
		log.debug("select(username = {}, password={})", username, password);
		
		Member member = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_USERNAME_AND_PASSWORD);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				member = toMemberFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(conn, stmt, rs);
		}
		
		return member;
	}
	
	// 회원정보를 담은 Member 객체를 생성하는 메서드
	public Member toMemberFromResultSet(ResultSet rs) throws SQLException {
	    Integer id = rs.getInt("id"); // 회원 ID
	    String username = rs.getString("username"); // 사용자 이름
	    String password = rs.getString("password"); // 비밀번호
	    String email = rs.getString("email"); // 이메일
	    Integer points = rs.getInt("points"); // 포인트
	    Timestamp createdTime = rs.getTimestamp("created_time"); // 생성 시간
	    Timestamp modifiedTime = rs.getTimestamp("modified_time"); // 수정 시간
	    
	    // 멤버 객체 빌드패턴으로 사용 생성
		Member member = Member.bulider()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.points(points)
				.createdTime(createdTime)
				.modifiedTime(modifiedTime)
				.build();
		
		return member;
	}
}
