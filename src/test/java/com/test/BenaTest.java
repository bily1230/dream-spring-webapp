package com.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.spring.manager.Manager;

import spring.ManagerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ManagerConfig.class)
public class BenaTest {
	@Autowired
	 private Manager manager;
	@Test
	public void test1(){
				 
		String name = manager.getName();
		assertNotNull(name);
	}
	
}
