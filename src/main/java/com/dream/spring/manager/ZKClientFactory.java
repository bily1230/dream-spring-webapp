/**
 * Project:dream-spring-webapp
 * File:ZKClientFactory.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.manager;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;
import org.springframework.util.backoff.ExponentialBackOff;

/**
 * @author nb
 * @date 2018年8月2日
 */
@Component
public class ZKClientFactory {
	private static final String ZK_CONNECT = "172.17.0.2:2181";

	public CuratorFramework getClient() {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.builder()
				.connectString(ZK_CONNECT)
				.retryPolicy(retryPolicy)
				.sessionTimeoutMs(6000)
				.connectionTimeoutMs(3000)
				.namespace("dream")
				.build();
		client.start();
		return client;
	}
}
