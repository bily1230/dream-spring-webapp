/**
 * Project:dream-spring-webapp
 * File:ZKTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.test;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

public class ZKTest {
	static final String CONNECT_ADD = "172.17.0.2:2181";
	static final int SESSION_OUTTIME = 2000;
	static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

	private ZKTest() {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("21");
		ZooKeeper zk = new ZooKeeper(CONNECT_ADD, SESSION_OUTTIME, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				// 获取事件的状态
				KeeperState keeperState = event.getState();
				EventType eventType = event.getType();
				// 如果是建立连接
				if (KeeperState.SyncConnected == keeperState) {
					if (EventType.None == eventType) {
						// 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
						connectedSemaphore.countDown();
						System.out.println("zk 建立连接");
					}
				}

			}
		});
		connectedSemaphore.await();

		System.out.println("..");
		zk.create("/testRoot", "testRoot".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zk.close();
	}
}
