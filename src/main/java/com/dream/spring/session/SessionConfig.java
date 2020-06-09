/**
 * Project:dream-spring-webapp
 * File:SessionConfig.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Spring Session 利用redis处理分布式 session 问题.
 * @author nb
 * @date 2018年10月9日
 */
@EnableRedisHttpSession
@Configuration
public class SessionConfig {

}
