package com.codeke.test.test3;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 15:36
 * @description
 */
public class Test3 {

	public static void main(String[] args) {

		/**
		 * 使用CountDownLatch可以解决
		 * countDownLatch.await() 阻塞线程
		 * countDownLatch.countDown() 通知
		 */


		ListAdd3 listAdd3 = new ListAdd3();
		CountDownLatch countDownLatch = new CountDownLatch(1);


		Thread t1 = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					listAdd3.add();
					System.out.println("当前线程：" + currentThread().getName() + " 添加了一个元素..");
					sleep(500);
					if (listAdd3.size() == 5) {
						System.out.println("已经发出通知..");
						countDownLatch.countDown();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1");


		Thread t2 = new Thread(() -> {
			if (listAdd3.size() != 5) {
				try {
					System.out.println("t2进入...");
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前线程：" + currentThread().getName() + " 收到通知线程停止..");
				throw new RuntimeException();
			}
		}, "t2");


		t2.start();
		try {
			sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
	}

}
