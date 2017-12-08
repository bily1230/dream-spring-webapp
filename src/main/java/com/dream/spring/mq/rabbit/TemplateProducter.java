package com.dream.spring.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.RabbitConfiguration;

public class TemplateProducter {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
/*		rabbitTemplate.setQueue("myqueue");
		rabbitTemplate.setExchange("myExchange");
		rabbitTemplate.setRoutingKey("direct");*/
		rabbitTemplate.setExchange("MyExchange");
		rabbitTemplate.setRoutingKey("k1");
		for(int i=0;i<10;i++){
			String message = "queq111xiaoxi"+i;
			rabbitTemplate.convertAndSend(message.getBytes());
		}
		
	    System.out.println("发送消息");
	}

}
