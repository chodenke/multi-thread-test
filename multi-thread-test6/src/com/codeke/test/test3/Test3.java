package com.codeke.test.test3;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:01
 * @description
 */
public class Test3 {

	public static void main(String[] args) {

		/**
		 * 死锁问题，在设计程序时就应该避免双方相互持有对方的锁的情况
		 */

		DeadLock d1 = new DeadLock();
		DeadLock d2 = new DeadLock();

		d1.setTag("a");
		d2.setTag("b");

		Thread t1 = new Thread(d1, "t1");
		Thread t2 = new Thread(d2, "t2");

		t1.start();

		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();


	}
}
