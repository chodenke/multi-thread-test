package com.codeke.test;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 14:02
 * @description
 */
public class MultiThread {

	private static int num;


	/**
	 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
	 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
	 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
	 */

	// 由于上述的理由，这里加不加synchronized在本测试中没有影响，因为两个线程中拿到的两个对象的锁，互不影响;而方法如果加static的话，就会去竞争同一把类锁
	public synchronized void printNum(String tag) {
		if ("a".equals(tag)) {
			System.out.println("tag a, before set num, num = " + num);
			num = 100;
			System.out.println("tag a, set num over, num = " + num);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if ("b".equals(tag)) {
			System.out.println("tag b, before set num, num = " + num);
			num = 200;
			System.out.println("tag b, set num over , num = " + num);
		}
		System.out.println("tag " + tag + ", num = " + num);
	}

}
