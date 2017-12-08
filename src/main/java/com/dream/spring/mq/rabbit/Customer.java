package com.dream.spring.mq.rabbit;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;



public class Customer {
	private final static String QUEUE_NAME = "myqueue1";
	
	@SuppressWarnings("resource")
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
		
		//公平转发  设置最大服务转发消息数量    只有在消费者空闲的时候会发送下一条信息。  
        
        
        final Consumer consumer = new DefaultConsumer(channel) {  
            @Override  
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {  
              String message = new String(body, "UTF-8");  
              System.out.println(" [x] Received ["  + envelope.getRoutingKey() + "] :'" + message + "'");  
            }  
          };  
          channel.basicConsume(QUEUE_NAME, true, consumer);  
	}  
	}

