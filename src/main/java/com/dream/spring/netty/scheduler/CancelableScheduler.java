package com.dream.spring.netty.scheduler;


import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/1
 **/
public interface CancelableScheduler {

	void cancel(SchedulerKey key);

	void update(ChannelHandlerContext ctx);


	void scheduler(Runnable runnable, long delay, TimeUnit unit);

	void scheduler(SchedulerKey key, Runnable runnable, long delay, TimeUnit unit);

	void schedulerCallback(SchedulerKey key, Runnable runnable, long delay, TimeUnit unit);


	void shutdown();
}
