package com.dream.spring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
	@Autowired
	private ManagerJunit managerJunit;


	public String getName(){
		return managerJunit.getName();
	}
}
