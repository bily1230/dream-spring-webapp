package com.dream.spring.mq.rabbit;



import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.RabbitConfiguration;
import spring.RootConfig;


public class Producter {

	public static void main(String[] args) {
		 ApplicationContext context =
			        new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		 RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		 
		 	rabbitTemplate.convertAndSend("Hello World");
		    System.out.println("Sent: Hello World");

	}

}
