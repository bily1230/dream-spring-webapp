package com.dream.spring.netty.scheduler;

import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/3
 **/
public class RetryTimerTask implements TimerTask {

	private Runnable task;

	private final int maxTry;

	private int retryTimes = 0;

	private final long tick;

	public RetryTimerTask(Runnable task, int max, long tick) {
		this.task = task;
		this.tick = tick;
		this.maxTry = max;
	}

	@Override
	public void run(Timeout timeout) throws Exception {
		try {
			task.run();
		} catch (Exception e) {
			if (retryTimes < maxTry) {
				retryTimes++;
				if (!timeout.isCancelled()) {
					putRetry(timeout);
				}
				System.out.println("******重试:" + retryTimes);
			} else {
				System.out.println("超过最大重试次数:" + retryTimes);
			}
		}
	}

	private void putRetry(Timeout timeout) {
		if (timeout == null) {
			return;
		}
		if (timeout.isCancelled()) {
			return;
		}
		Timer timer = timeout.timer();
		timer.newTimeout(timeout.task(), tick, TimeUnit.SECONDS);
	}
}
