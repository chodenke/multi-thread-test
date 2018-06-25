package com.codeke.test;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 14:08
 * @description
 */
public class Test {

	public static void main(String[] args) {

		/**
		 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
		 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
		 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
		 */

		MultiThread multiThread1 = new MultiThread();
		MultiThread multiThread2 = new MultiThread();

		Thread t1 = new Thread(() -> multiThread1.printNum("a"));
		Thread t2 = new Thread(() -> multiThread2.printNum("b"));

		t1.start();
		t2.start();
	}
}
