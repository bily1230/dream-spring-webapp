/**
 * Project:dream-spring-webapp
 * File:WebSocketController.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.controller.demo;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author nb
 * @date 2018年8月23日
 */
@ServerEndpoint("/websocket")
public class WebSocketController {
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("有新连接加入！");
	}
	
	@OnClose
	public void onClose() {
		
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("客户端的消息：" + message);
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		
	}
	
	
}
