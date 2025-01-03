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

public enum PostDao {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(PostDao.class);
	private final HikariDataSource ds = DataSourceUtil.INSTANCE.getDataSource();
	
	
	private static final String SQL_SELECT = 
			"select * from posts order by id desc";
	
	public List<Post> select(){
		
		List<Post> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Post post = toPostFromResultSet(rs);
				list.add(post);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return list;
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
