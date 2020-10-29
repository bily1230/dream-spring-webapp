package com.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/15
 **/
public class MqTest1 {

	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			         factory.setHost("221.130.129.139");
			         factory.setUsername("sxfw");
			        factory.setPassword("sxfw");
			       factory.setPort(5672);
			       Connection connection = factory.newConnection();
			       Channel channel = connection.createChannel();
			        // 声明队列
			      //  channel.queueDeclare("QUEUE", true, false, false, null);
			        String message = "Hello World! 你好，陕西测试";
			        // 发行消息到队列
			         channel.basicPublish("", "QUEUE", null, message.getBytes());
			        System.out.println(" [x] Sent '" + message + "'");
			        channel.close();
			       connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
