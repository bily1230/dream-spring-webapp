package com.dream.spring.netty.handler;

import io.netty.channel.Channel;

/**
 * .
 *
 * @Description channel de.
 * @Author ningbin
 * @Date 2020/8/28
 **/
public class Connection {
	private Channel channel;
	private String sessionId;


	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
