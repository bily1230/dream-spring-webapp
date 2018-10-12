package com.dream.spring.mq.rabbit.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverMessageListener implements MessageListener{

		@Override
		public void onMessage(Message message) {
			  System.out.println("Receiveryyy************************ : " + message);
			
		}

}
