package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.spring.manager.Manager;
import spring.JunitConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JunitConfig.class)
public class BenaTest {
	@Autowired
	 private Manager manager;
	@Test
	public void test1(){
				 
		String name = manager.getName();
		assertEquals("lihan", name);
	}
	
}
