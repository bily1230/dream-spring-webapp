package com.dream.spring.mq.rabbit.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverQueue{

	@RabbitListener(queues = "MyQueue")
    public void handle(String str) {
        System.out.print("Receiver : ");
    }
}
