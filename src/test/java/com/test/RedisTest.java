/**
 * Project:dream-spring-webapp
 * File:RedisTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.test;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * .
 *
 * @author nb
 * @date 2018年9月19日
 */
public class RedisTest {
	@Test
	public void connect() {
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("47.98.251.14", 6379);
		jedis.set("name", "sewqe");
		jedis.set("personid", "wangsan");
		String key = jedis.get("name");
		System.out.println("连接成功" + key);
		//查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		jedis.close();
	}


	@Test
	public void redisCluster() {
		//创建一连接，JedisCluster对象,在系统中是单例存在

		Set<HostAndPort> nodes = new HashSet<>();

		nodes.add(new HostAndPort("10.222.11.54", 6380));

		nodes.add(new HostAndPort("10.222.11.54", 6381));

		nodes.add(new HostAndPort("10.222.11.54", 6382));

		nodes.add(new HostAndPort("10.222.11.54", 6383));

		nodes.add(new HostAndPort("10.222.11.54", 6384));

		nodes.add(new HostAndPort("10.222.11.54", 6385));

		JedisCluster cluster = new JedisCluster(nodes);

		//执行JedisCluster对象中的方法，方法和redis一一对应。

		cluster.set("cluster-test", "my jedis cluster test");

		String result = cluster.get("cluster-test");

		System.out.println(result);

		//程序结束时需要关闭JedisCluster对象

		try {
			cluster.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
