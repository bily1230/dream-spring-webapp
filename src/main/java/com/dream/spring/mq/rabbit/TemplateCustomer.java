package com.dream.spring.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dream.spring.mq.RabbitConfiguration;

public class TemplateCustomer {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
		/*rabbitTemplate.setQueue("myqueue");*/
		rabbitTemplate.setExchange("myExchange");
		rabbitTemplate.setRoutingKey("k2");
		
		System.out.println("Received-------:"+rabbitTemplate.receive());
		
	}
}
