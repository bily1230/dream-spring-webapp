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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nb
 * @date 2018年8月23日
 */
@ServerEndpoint("/websocket")
public class WebSocketController {
	private Session session;
	private static Map<String, WebSocketController> clients = new ConcurrentHashMap<String, WebSocketController>();
	@OnOpen
	public void onOpen(Session session) {

		clients.put("xiaoming", this);
		System.out.println("有新连接加入！");
	}
	
	@OnClose
	public void onClose() {
		
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {

		System.out.println("客户端的消息：" + message);
		for(int i = 0; i<5;i++){
			sendMessageTo("receiver:"+i,"222");
		}
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		
	}

	public void sendMessageTo(String message, String To){
		for (WebSocketController item : clients.values()) {
				item.session.getAsyncRemote().sendText(message);
		}
	}
}
