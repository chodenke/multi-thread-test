package com.codeke.test.test4;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:08
 * @description
 */
public class Test4 {
	public static void main(String[] args) {

		/**
		 * 同一对象属性的修改不会影响锁的情况
		 */

		ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(() -> modifyLock.changeAttributte("张三",20), "t1");
		Thread t2 = new Thread(() -> modifyLock.changeAttributte("李四",21), "t2");

		t1.start();

		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();
	}
}
