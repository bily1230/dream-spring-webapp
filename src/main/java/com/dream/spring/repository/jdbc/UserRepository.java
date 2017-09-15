package com.dream.spring.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.spring.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	DataSource dataSource;
	
	public void insertUser(User user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user (name,age) values(?,?)";
		
		try {
			 connection = (Connection) dataSource.getConnection();
			 pstmt = (PreparedStatement) connection.prepareStatement(sql);
	         pstmt.setString(1, user.getName());
	         pstmt.setString(2, user.getAge());
	         pstmt.executeUpdate();
		       
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 pstmt.close();
		     connection.close();
		}
		
	        
	}

}
