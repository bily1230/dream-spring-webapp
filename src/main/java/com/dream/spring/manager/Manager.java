package com.dream.spring.juintdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
	@Autowired
	private ManagerName managerName;


	public String getName(){
		managerName
	}
}
