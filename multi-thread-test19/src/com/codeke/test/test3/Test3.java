package com.codeke.test.test3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 11:44
 * @description
 */
public class Test3 {

	public static void main(String[] args) {


		/**
		 * Semaphore是计数信号量。
		 * Semaphore管理一系列许可证。
		 * 每个acquire方法阻塞，直到有一个许可证可以获得然后拿走一个许可证；每个release方法增加一个许可证，这可能会释放一个阻塞的acquire方法。
		 * 然而，其实并没有实际的许可证这个对象，Semaphore只是维持了一个可获得许可证的数量。
		 * Semaphore经常用于限制获取某种资源的线程数量。
		 */

		// 线程池
		ExecutorService exec = Executors.newCachedThreadPool();

		// 只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);

		// 模拟20个客户端访问
		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = () -> {
				try {
					// 获取许可
					semp.acquire();
					System.out.println("Accessing: " + NO);
					//模拟实际业务逻辑
					Thread.sleep(5000);
					// 访问完后，释放
					semp.release();
				} catch (InterruptedException e) {
				}
 			};
			exec.execute(run);
		}


		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(semp.getQueueLength());  // 等待信号量的队列长度

		// 退出线程池
		exec.shutdown();
	}

}
