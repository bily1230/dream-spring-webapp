package com.dream.spring.controller;


import java.sql.SQLException;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate.RabbitConverterFuture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dream.spring.repository.UserDataJpaRepository.UserDataJpaRepository;
import com.dream.spring.repository.jdbc.UserRepository;
import com.dream.spring.repository.jdbcTemplate.UserTemplateRepository;
import com.dream.spring.repository.jpa.UserJpaRepository;

/**
 * Created by ning on 2017/8/20.
 */

@Controller
@RequestMapping("/helloWord")
public class HelloWord {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWord.class);
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
    
    @Autowired
    AsyncRabbitTemplate asyncRabbitTemplate;
	
    @RequestMapping(value="/{age}/readWord" ,method = RequestMethod.GET)
    public String readWord(@PathVariable("age") String age, @RequestParam("name")String name,
                           RedirectAttributes model) throws NamingException, SQLException{
    	
    	
    	/*rabbitTemplate.setExchange("MyExchange");
    	rabbitTemplate.setRoutingKey("k1");*/
    	//rabbitTemplate.setRoutingKey("k2");
		/*rabbitTemplate.setExchange("myExchange");
		rabbitTemplate.setRoutingKey("direct");*/
    	
		Message message = MessageBuilder.withBody("小明".getBytes())
    			.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
    			.setHeader("name", "111")
    			.build();
		
		LOGGER.info("2111111111");
		LOGGER.debug("rabbitmq log 测试");
		//Object reply = rabbitTemplate.convertSendAndReceive(message);
		
		/*ListenableFuture<Object> future = asyncRabbitTemplate.convertSendAndReceive(message);
		
		Object reply = null;
	        try {
				reply = future.get();
				System.out.println("返回成功："+reply);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		RabbitConverterFuture<String> future = asyncRabbitTemplate.convertSendAndReceive(message);
		
		future.addCallback(new ListenableFutureCallback<String>() {

	        @Override
	        public void onSuccess(String result) {
	        	System.out.println("返回成功："+result);
	        }

	        @Override
	        public void onFailure(Throwable ex) {
	        	System.out.println("返回失败："+ex.getMessage());
	        }

	    });
			
		System.out.println("发送消息-------");
		
	    
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
