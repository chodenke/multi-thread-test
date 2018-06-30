package com.codeke.test.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:48
 * @description
 */
public class Task implements Runnable {

	private static AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		try {
			int temp = count.incrementAndGet();
			System.out.println("任务" + temp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
