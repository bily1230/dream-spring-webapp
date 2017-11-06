package com.dream.spring.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.RabbitConfiguration;

public class Customer {

	public static void main(String[] args) {
		ApplicationContext context =
		        new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		Object name = rabbitTemplate.convertSendAndReceive("myqueue");
		System.out.print("recesiver:"+name.toString());
	}

}
