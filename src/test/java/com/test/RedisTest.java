/**
 * Project:dream-spring-webapp
 * File:RedisTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * .
 * @author nb
 * @date 2018年9月19日
 */
public class RedisTest {
	@Test
	public void connect() {
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("47.98.251.14", 6379);
		jedis.set("test", "sewqe");
		jedis.set("personid", "wangsan");
		String key = jedis.get("name");
		System.out.println("连接成功" + key);
		//查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		jedis.close();
	}
}
