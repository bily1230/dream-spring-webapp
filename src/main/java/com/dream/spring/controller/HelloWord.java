package com.dream.spring.controller;


import java.sql.SQLException;

import com.dream.spring.domain.User;
import com.dream.spring.repository.UserDataJpaRepository.UserDataJpaRepository;
import com.dream.spring.repository.jdbc.UserRepository;
import com.dream.spring.repository.jdbcTemplate.UserTemplateRepository;
import com.dream.spring.repository.jpa.UserJpaRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by ning on 2017/8/20.
 */

@Controller
@RequestMapping("/helloWord")
public class HelloWord {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTemplateRepository userTemplateRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UserDataJpaRepository userDataJpaRepository;
    
    @Autowired
    RabbitTemplate rabbitTemplate;
	
    @RequestMapping(value="/{age}/readWord" ,method = RequestMethod.POST)
    public String readWord(@PathVariable("age") String age, @RequestParam("name")String name,
                           RedirectAttributes model) throws NamingException, SQLException{
    	
    	
    	//rabbitTemplate.setQueue("MyQueue");
    	rabbitTemplate.setExchange("MyExchange");
    	rabbitTemplate.setRoutingKey("k1");
    	//rabbitTemplate.setRoutingKey("k2");
		/*rabbitTemplate.setExchange("myExchange");
		rabbitTemplate.setRoutingKey("direct");*/
		for(int i=0;i<10;i++){
			rabbitTemplate.convertAndSend("xiaoxinzang-"+i);
			System.out.println("发送消息"+i);
		}
		
	    
       /* User user = new User();
        user.setName(name);
        user.setAge(age);
        System.out.println("中国梦！作为中国人---"+name+"--"+age);
        model.addAttribute("name",name);
        model.addAttribute("age",999);
        model.addFlashAttribute(user);

        User finduser =  userJpaRepository.findUser();
        if(finduser!=null){
            System.out.println("chaxun："+finduser.getAge());
        }else{
            System.out.println("nononono");
        }

        //userTemplateRepository.addUser(user);
        // userRepository.insertUser(user);

        Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		String str = (String) envCtx.lookupLink("filesystem/root");
		System.out.println("JNDI"+str);*/
        
        return "";
    }
}
