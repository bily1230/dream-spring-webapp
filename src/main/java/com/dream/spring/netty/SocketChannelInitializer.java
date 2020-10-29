package com.dream.spring.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * .
 *
 * @Description.
 * @Author ningbin
 * @Date 2020/8/28
 **/
public class SocketChannelInitializer extends ChannelInitializer<Channel> {
	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		addSslHandler(pipeline);
		addSocketHandler(pipeline);
	}

	private void addSocketHandler(ChannelPipeline pipeline) {
	}

	private void addSslHandler(ChannelPipeline pipeline) {
	}


}
