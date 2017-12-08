package com.dream.spring.mq.rabbit;



import java.io.IOException;
import java.util.concurrent.TimeoutException;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;



public class Producter {
	
	private final static String QUEUE_NAME = "myqueue1";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();    
        factory.setHost("localhost");    
        //指定用户 密码  
        factory.setUsername("guest");  
        factory.setPassword("guest");  
        //指定端口  
        factory.setPort(AMQP.PROTOCOL.PORT);
		 	
		 Connection connection = factory.newConnection();
		 Channel channel = connection.createChannel();
		 
		 boolean durable = true;
		 
		 channel.queueDeclare(QUEUE_NAME, durable,  false, false, null);
		 for(int i =0;i<5;i++){
			 String message = i + "hellpword";
			 channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			 System.out.println("Sent: "+message);
		 }
		 
		channel.close();
		connection.close();

	}

}
