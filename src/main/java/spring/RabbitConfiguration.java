package spring;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.dream.spring.mq.rabbit.listener.RabbitReceiverMessageListener;




/**
 *  Rabbit
 * @author nb
 * 2017-10-18
 */

@Configuration
public class RabbitConfiguration {
	
	@Bean
    public ConnectionFactory connectionFactory() throws Exception {
		 CachingConnectionFactory connectionFactory =
			        new CachingConnectionFactory("localhost");
			        connectionFactory.setUsername("guest");
			        connectionFactory.setPassword("guest");
			        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 重试功能
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    	
    	RabbitTemplate template = new RabbitTemplate(connectionFactory);
    	RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500);
        backOffPolicy.setMultiplier(10.0);
        backOffPolicy.setMaxInterval(10000);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        template.setRetryTemplate(retryTemplate);
        return template;
    }
    
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
    	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    	container.setConnectionFactory(connectionFactory);
    	//container.setQueues(myQueue());
    	container.setMessageListener(rabbitReceiverMessageListener());
    	return container;
    }
    
    @Bean
    public RabbitReceiverMessageListener rabbitReceiverMessageListener(){
    	return new RabbitReceiverMessageListener();
    }
    
    @Bean
    public Queue myQueue() {
       return new Queue("myqueue");
    }

}
