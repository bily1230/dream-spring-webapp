package com.dream.spring.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * .
 *
 * @Description netty.
 * @Author ningbin
 * @Date 2020/8/28
 **/
public class SocketServer {


	private SocketChannelInitializer channelInitializer = new SocketChannelInitializer();
	private EventLoopGroup bossGroup;
	private EventLoopGroup workGroup;


	private void start() {
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap
				.group(bossGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(8080))
				.childHandler(channelInitializer);
		ChannelFuture f = null;
		bootstrap.bind();
	}

	private void stop() {
		bossGroup.shutdownGracefully().syncUninterruptibly();
		workGroup.shutdownGracefully().syncUninterruptibly();
	}

	protected void initGroup() {
		bossGroup = new NioEventLoopGroup(10);
		workGroup = new NioEventLoopGroup(50);
	}

}
