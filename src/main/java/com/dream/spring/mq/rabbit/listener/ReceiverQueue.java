package com.dream.spring.mq.rabbit.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ReceiverQueue{

	@RabbitListener(queues = "MyQueue1")
	@SendTo("replyExchange/k2")
    public String handle(Message message) {
        System.out.println("Receiver------ : "+ message.getBody());
        return "pppp";
    }
}
