/**
 * Project:dream-spring-webapp
 * File:SessionConfig.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisShardInfo;

/**
 * .
 * @author nb
 * @date 2018年10月9日
 */
@EnableRedisHttpSession
@Configuration
public class SessionConfig {
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisShardInfo jeJedisShardInfo = new JedisShardInfo("47.98.251.14", 6379);
		jeJedisShardInfo.setConnectionTimeout(1000);
		return new JedisConnectionFactory(jeJedisShardInfo);
	}
}
