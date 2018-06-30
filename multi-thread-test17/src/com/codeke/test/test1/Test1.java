package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:29
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		Temp command = new Temp();

		// 定时执行任务的线程池
		// ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		// ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 5, 1, TimeUnit.SECONDS);

		// 固定大小的线程池
		// ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

		// 不固定大小的线程池
		// ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// 单线程执行器
		// ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

	}

}
