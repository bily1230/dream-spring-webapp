package com.test.scheduler;

import com.dream.spring.netty.scheduler.RetryTimerTask;
import io.netty.util.HashedWheelTimer;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/3
 **/
public class HashedWheelTest {

	@Test
	public void scheduler() {
		HashedWheelTimer timer = new HashedWheelTimer();
		timer.newTimeout(new RetryTimerTask(new Runnable() {

			@Override
			public void run() {
				System.out.println("--------");
				String a = null;
				if (a.equals("11")) {

				}
			}
		}, 3, 5), 3, TimeUnit.SECONDS);

		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
		}
	}


}
