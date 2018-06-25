package com.codeke.test.test5;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:13
 * @description
 */
public class Test5 {

	public static void main(String[] args) {

		/**
		 * 使用synchronized代码块加锁,比较灵活
		 */

		ObjectLock objectLock = new ObjectLock();

		Thread t1 = new Thread(objectLock::method1, "t1");
		Thread t2 = new Thread(objectLock::method2, "t2");
		Thread t3 = new Thread(objectLock::method3, "t3");

		t1.start();
		t2.start();
		t3.start();
	}

}
