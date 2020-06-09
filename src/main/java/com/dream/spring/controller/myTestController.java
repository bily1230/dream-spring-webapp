package com.dream.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dream.spring.manager.AspectJManager;

@RestController
@RequestMapping("/test")
public class myTestController {

	@Autowired
	private AspectJManager aspectJManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(myTestController.class);

	@RequestMapping(value = "/put", method = RequestMethod.POST)
	public Object test(HttpServletRequest request) {

		LOGGER.info("--------------");
		/*String bb = (String) request.getSession().getAttribute("ningbin");
		System.out.println(bb);
		request.getSession().setAttribute("ningbin", "bily1230");
		String name = request.getParameter("name");*/
		System.out.println("1111****************");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "111");
		map.put("age", 12);
		return map;
	}

	@RequestMapping(value = "/tput/{age}", method = RequestMethod.POST)
	public Object testput(@PathVariable("age") String age, HttpServletRequest request) {
		//String username =  user.get("name");
		request.getSession().setAttribute("ningbin", "bily1230");
		String name = request.getParameter("name");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", age);
		map.put("age", name);
		return map;
	}
}
