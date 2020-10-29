package com.dream.spring.mq;

import com.dream.spring.mq.rabbit.listener.RabbitReceiverMessageListener;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Rabbit
 * @author nb
 *         2017-10-18
 */

@Configuration
@EnableRabbit
public class RabbitConfiguration {

	private final static String QUEUE_ONE = "MyQueue1";
	private final static String QUEUE_TWO = "MyQueue2";
	private final static String EXCHANGE_ONE = "MyExchange";
	private final static String REPLY_EXCHANGE = "replyExchange";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("47.98.251.14", 5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	/**
	 * 重试功能
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		RetryTemplate retryTemplate = new RetryTemplate();
		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(500);
		backOffPolicy.setMultiplier(10.0);
		backOffPolicy.setMaxInterval(10000);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		template.setRetryTemplate(retryTemplate);
		template.setMandatory(true);

		return template;
	}

	/*
	 * AsyncRabbitTemplate 中 replyRebbitTemplate() 和simpleMessageListenerContainer() 中的 setMessageConverter()消息转换器必须相同
	 */
	/*@Bean
	public AsyncRabbitTemplate asyncRabbitTemplate() {
		return new AsyncRabbitTemplate(replyRabbitTemplate(), simpleMessageListenerContainer(), "replyExchange/k2");
	}

	@Bean
	public RabbitTemplate replyRabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		RetryTemplate retryTemplate = new RetryTemplate();
		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(500);
		backOffPolicy.setMultiplier(10.0);
		backOffPolicy.setMaxInterval(10000);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		rabbitTemplate.setRetryTemplate(retryTemplate);
		rabbitTemplate.setMessageConverter(new SimpleMessageConverter());
		rabbitTemplate.setRoutingKey("k1");
		rabbitTemplate.setExchange(EXCHANGE_ONE);
		rabbitTemplate.setReplyTimeout(6000);
		rabbitTemplate.setMandatory(true);
		return rabbitTemplate;
	}
*/
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		factory.setMessageConverter(new SimpleMessageConverter());
		return factory;
	}

	@Bean
	public MessageConverter jsonConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
		SimpleMessageListenerContainer factory = new SimpleMessageListenerContainer();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		factory.setMessageConverter(new SimpleMessageConverter());
		factory.addQueueNames(QUEUE_TWO);
		factory.setMessageListener(rabbitReceiverMessageListener());
		return factory;
	}

	@Bean
	public RabbitReceiverMessageListener rabbitReceiverMessageListener() {
		return new RabbitReceiverMessageListener();
	}

	@Bean
	public Queue q1() {
		return new Queue(QUEUE_ONE);
	}

	@Bean
	public Queue q2() {
		return new Queue(QUEUE_TWO);
	}

	@Bean
	DirectExchange e1() {
		return new DirectExchange(EXCHANGE_ONE);
	}

	@Bean
	DirectExchange replyExchange() {
		return new DirectExchange(REPLY_EXCHANGE);
	}

	@Bean
	public Binding b1() {
		return BindingBuilder.bind(q1()).to(e1()).with("k1");
	}

	@Bean
	public Binding b2() {
		return BindingBuilder.bind(q2()).to(replyExchange()).with("k2");
	}

	@Bean
	public List<Declarable> ds() {
		return Arrays.<Declarable>asList(new DirectExchange("e4", false, true), new Queue("q4", false, false, true), new Binding("q4", DestinationType.QUEUE, "e4", "k4", null));
	}

}
