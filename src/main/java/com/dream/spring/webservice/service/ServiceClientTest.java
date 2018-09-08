/**
 * Project:dream-spring-webapp
 * File:ServiceClientTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.webservice.service;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.dream.spring.manager.Manager;

/**
 * @author nb
 * @date 2018年8月24日
 */

@WebService
public class ServiceClientTest{
	@Autowired
	private Manager manager; 
	
	public String getName(String name) {
		return "姓名:" + name + manager.getName() ;
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1088/webServiceTest", new ServiceClientTest());
	     System.out.println("发布成功!");
	}
	
}
