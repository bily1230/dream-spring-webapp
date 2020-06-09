package com.dream.spring.controller.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

	@RequestMapping("/form")
	public Object formPost(HttpServletRequest request){
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("name", name);
		map.put("age", age);
		return map;
	}
	
	@RequestMapping("/payLoad")
	public Object formPost(@RequestBody Map map){
		String name = (String) map.get("name");
		String age = (String) map.get("age");

		Map<String,Object> map1  = new HashMap<String,Object>();
		map1.put("name", name);
		map1.put("age", age);
		return map1;
	}
	
	
}
