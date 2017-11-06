package com.dream.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class myTestController {
	
	@ResponseBody
	@RequestMapping(value="/put", method =RequestMethod.PUT)
	public Object test(HttpServletRequest request ){
		
		String name = request.getParameter("name");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("age", 12);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/tput", method = RequestMethod.POST)
	public Object testput(HttpServletRequest request){
		String name = request.getParameter("name");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "22");
		map.put("age", name);
		return map;
	}
}
