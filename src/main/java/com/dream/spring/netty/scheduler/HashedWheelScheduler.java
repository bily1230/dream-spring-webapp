package com.dream.spring.netty.scheduler;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/3
 **/
public class HashedWheelScheduler {

	private final HashedWheelTimer timer;

	private final ConcurrentHashMap<String, Timeout> taskMap = new ConcurrentHashMap<>();

	public HashedWheelScheduler() {
		timer = new HashedWheelTimer();
	}

	public void cancel(String key) {
		Timeout timeout = taskMap.get(key);
		if (timeout != null) {
			timeout.cancel();
		}
	}

	public void scheduler(final Runnable runnable, long delay, TimeUnit unit) {
		timer.newTimeout(new TimerTask() {
			@Override
			public void run(Timeout timeout) throws Exception {
				runnable.run();
			}
		}, delay, unit);
	}

	public void scheduler(String key, final Runnable runnable, long delay, TimeUnit unit) {
		Timeout timeout = timer.newTimeout(new TimerTask() {
			@Override
			public void run(Timeout timeout) throws Exception {
				System.out.println("888888");
				runnable.run();
			}
		}, delay, unit);

		if (!timeout.isExpired()) {
			taskMap.put(key, timeout);
		}
	}
}
