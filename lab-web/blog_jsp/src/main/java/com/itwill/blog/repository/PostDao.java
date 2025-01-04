package com.itwill.blog.repository;

import static com.itwill.blog.datasourceutil.DataSourceUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.blog.datasourceutil.DataSourceUtil;
import com.itwill.blog.domain.Post;
import com.zaxxer.hikari.HikariDataSource;

// 게시물 데이터 접근을 위한 DAO 클래스
public enum PostDao {
	INSTANCE; // 싱글톤 패턴 구현
	
	// 디버그 로그를 출력하기 위한 객체 생성.
	private static final Logger log = LoggerFactory.getLogger(PostDao.class);
	
	// HikariCP를 사용한 데이터베이스 커넥션 풀 객체 생성
	private final HikariDataSource ds = DataSourceUtil.INSTANCE.getDataSource();
	
	// 게시물 데이터를 최신순으로 조회하는 SQL_SELECT 쿼리문
	private static final String SQL_SELECT = 
			"select * from posts order by id desc";
	
	// 게시물 데이터를 데이터베이스에서 조회하여 리스트로 반환.
	public List<Post> select(){
		
		List<Post> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//커넥션 풀 데이터 베이스 연결
			conn = ds.getConnection(); 	
			
			//게시물 조회를 위한 SQL_SELECT 쿼리 준비
			stmt = conn.prepareStatement(SQL_SELECT);   
			
			//쿼리 실행 후 결과(ResultSet) 반환
			rs = stmt.executeQuery();					
			
			//ResultSet을 post 객체로 변환하여 리스트에 추가
			while(rs.next()) {							
				Post post = toPostFromResultSet(rs);
				list.add(post);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);						//리소스 해제
		}
		return list;									//게시물 리스트 반환.
	}
	
	// 게시물 데이터를 삽입하는 SQL_INSERT 쿼리문
	private static final String SQL_INSERT = 
			"insert into posts (title, content, author, created_time, modified_time) "
			+ "values(?, ?, ?, systimestamp, systimestamp)";
	
	// 게시물 데이터를 데이터베이스에서 생성하여 업데이트.
	public int insert(Post post) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//커넥션 풀 데이터 베이스 연결
			conn = ds.getConnection();
			
			// 게시물 생성을 위한 SQL_INSERT 쿼리
			stmt = conn.prepareStatement(SQL_INSERT);
			
			//게시물 데이터를 SQL 쿼리 파라미터에 바인딩
			stmt.setString(1, post.getTitle());		//첫 번째 파라미터: 제목
			stmt.setString(2, post.getContent());	//두 번째 파라미터: 내용
			stmt.setString(3, post.getAuthor());	//세 번째 파라미터: 작성자
			
			//SQL 업데이트 실행 후 행의 수 반환.
			result = stmt.executeUpdate();
			
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			close(conn, stmt); 				
		}
				
		return result;		
	}
	
	private Post toPostFromResultSet(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("ID");
		String title = rs.getString("TITLE");
		String content = rs.getString("CONTENT");
		String author = rs.getString("AUTHOR");
		Timestamp createdTime = rs.getTimestamp("CREATED_TIME");
		Timestamp modifiedTime = rs.getTimestamp("MODIFIED_TIME");
		
		Post post = Post.bulider()
				.id(id).title(title).content(content).author(author)
				.createdTime(createdTime).modifiedTime(modifiedTime)
				.build();
		
		return post;
	}
}
