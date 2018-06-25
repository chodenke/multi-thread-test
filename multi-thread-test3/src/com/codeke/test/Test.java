package com.codeke.test;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 14:56
 * @description
 */
public class Test {

	public static void main(String[] args) {

		MyObject mo = new MyObject();

		Thread t1 = new Thread(mo::method1, "t1");
		Thread t2 = new Thread(mo::method2, "t2");


		/**
		 * 分析：
		 * t1线程先持有object对象的Lock锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
		 * t1线程先持有object对象的Lock锁，t2线程如果在这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
		 */

		t1.start();
		t2.start();


	}
}
