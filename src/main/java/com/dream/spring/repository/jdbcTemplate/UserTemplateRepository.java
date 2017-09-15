package com.dream.spring.repository.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dream.spring.domain.User;

@Repository
public class UserTemplateRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sql = "insert into user (name,age) values(?,?)";
	
	public void addUser(User user){
		jdbcTemplate.update(sql, user.getName(),user.getAge());
	}
}
