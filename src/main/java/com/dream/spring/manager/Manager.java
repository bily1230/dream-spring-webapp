package com.dream.spring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Manager {
	
	@Autowired
	private ManagerName managerName;
	
	public String getName(){
		return managerName.getName();
	}
}
