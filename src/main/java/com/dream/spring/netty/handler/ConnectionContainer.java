package com.dream.spring.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/8/28
 **/
public class ConnectionContainer {
	private final ConcurrentHashMap<String, Connection> uuidConnections = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<Channel, Connection> channelConnections = new ConcurrentHashMap<>();

	public void addConneciton(Connection connection) {
		uuidConnections.put(connection.getSessionId(), connection);
	}

	public void removeConnection(UUID sessionId) {
		uuidConnections.remove(sessionId);
	}

	public Connection getConnection(UUID sessionId) {
		return uuidConnections.get(sessionId);
	}


	public void add(Channel channel, Connection connection) {
		channelConnections.put(channel, connection);
	}

	public void remove(Channel channel) {
		channelConnections.remove(channel);
	}

	public Connection get(Channel channel) {
		return channelConnections.get(channel);
	}

}
