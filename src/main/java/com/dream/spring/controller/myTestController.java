package com.dream.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dream.spring.domain.User;

@RestController
@RequestMapping("/test")
public class myTestController {
	
	@RequestMapping(value="/put", method =RequestMethod.PUT)
	public Object test(HttpServletRequest request ){
		
		String name = request.getParameter("name");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("age", 12);
		return map;
	}
	
	@RequestMapping(value="/tput/{age}", method = RequestMethod.POST)
	public Object testput(@PathVariable("age") String age, HttpServletRequest request){
		//String username =  user.get("name");
		String name = request.getParameter("name");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", age);
		map.put("age", name);
		return map;
	}
}
