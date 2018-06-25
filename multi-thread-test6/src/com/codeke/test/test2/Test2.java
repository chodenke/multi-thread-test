package com.codeke.test.test2;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 11:36
 * @description
 */
public class Test2 {

	public static void main(String[] args) {

		ChangeLock changeLock = new ChangeLock();
		Thread t1 = new Thread(changeLock::method1, "t1");
		Thread t2 = new Thread(changeLock::method1, "t2");
		Thread t3 = new Thread(changeLock::method2, "t3");

		t1.start();

		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();

		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t3.start();

	}
}
