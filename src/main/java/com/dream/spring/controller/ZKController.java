/**
 * Project:dream-spring-webapp
 * File:ZKController.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.utils.CloseableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dream.spring.manager.ZKClientFactory;

/**
 * @author nb
 * @date 2018年8月2日
 */
@Controller
@RequestMapping("/zktest")
public class ZKController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ZKController.class);

	@Autowired
	private ZKClientFactory zkcleint;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateZKNode() {
		String path = "/node";
		CuratorFramework client = zkcleint.getClient();
		try {
			client.create().forPath(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final NodeCache nodeCache = new NodeCache(client, path);
		try {
			nodeCache.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		nodeCache.getListenable().addListener(new NodeCacheListener() {

			@Override
			public void nodeChanged() throws Exception {
				System.out.println("监听事件触发");
				System.out.println("node changed new value : {" + nodeCache.getCurrentData().getData());
				LOGGER.info("node changed new value : {}", new String(nodeCache.getCurrentData().getData()));
			}
		});

		try {
			client.setData().forPath(path, "456".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
   //	leaderNode();
		return "";
	}

	private void leaderNode() {
		String path = "/leader";
		List<CuratorFramework> clients = new ArrayList<>();
		List<LeaderLatch> latchList = new ArrayList<>();
		try {
			for (int i = 1; i < 5; i++) {
				CuratorFramework client = zkcleint.getClient();
				clients.add(client);
				final LeaderLatch leaderLatch = new LeaderLatch(client, path, "client#" + i);
				leaderLatch.addListener(new LeaderLatchListener() {

					@Override
					public void notLeader() {
						System.out.println(leaderLatch.getId() + ":I am not leader. I will do nothing!不是leader");
					}

					@Override
					public void isLeader() {
						System.out.println(leaderLatch.getId() + ":I am not leader. I will do nothing 是××××××××!");
					}
				});
				leaderLatch.start();
				latchList.add(leaderLatch);
				Thread.sleep(Integer.MAX_VALUE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			for (CuratorFramework client : clients) {
				CloseableUtils.closeQuietly(client);
			}

			for (LeaderLatch leaderLatch : latchList) {
				CloseableUtils.closeQuietly(leaderLatch);
			}
		}
	}

}
