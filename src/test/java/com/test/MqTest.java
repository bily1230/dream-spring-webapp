package com.test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * .
 *
 * @Description .
 * @Author ningbin
 * @Date 2020/9/14
 **/
public class MqTest {

	public static void main(String[] args) {

		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("221.130.129.139");
			factory.setPort(5672);
			factory.setUsername("sxfw");
			factory.setPassword("sxfw");
			Connection connection = null;
			connection = factory.newConnection();
			final Channel channel = connection.createChannel();
			channel.basicQos(64);
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					System.out.println("接收消息:" + new String(body, Charset.forName("UTF-8")));
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					channel.basicAck(envelope.getDeliveryTag(),false);
				}
			};
			channel.basicConsume("QUEUE", consumer);
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}


	}
}
