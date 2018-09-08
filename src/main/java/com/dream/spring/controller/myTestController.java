package com.dream.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
import com.dream.spring.manager.AspectJManager;
import com.dream.spring.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> c1494374afe010e42d98605a323349d510623daa
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class myTestController {
<<<<<<< HEAD

    @Autowired
    private AspectJManager aspectJManager;

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public Object test(HttpServletRequest request) {
        aspectJManager.show("lihan");

        String name = request.getParameter("name");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("age", 12);
        return map;
    }

    @RequestMapping(value = "/tput/{age}", method = RequestMethod.POST)
    public Object testput(@PathVariable("age") String age, HttpServletRequest request) {
        //String username =  user.get("name");
        String name = request.getParameter("name");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", age);
        map.put("age", name);
        return map;
    }
=======
	
	private static final Logger LOGGER = LoggerFactory.getLogger(myTestController.class);
	
	@RequestMapping(value="/put", method =RequestMethod.PUT)
	public Object test(HttpServletRequest request ){
		
		LOGGER.info("--------------");
		
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
>>>>>>> c1494374afe010e42d98605a323349d510623daa
}
