package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 11:22
 * @description
 */
public class Test1 {

	public static void main(String[] args) {
		StringLock stringLock = new StringLock();

		Thread t1 = new Thread(stringLock::method, "t1");
		Thread t2 = new Thread(stringLock::method, "t2");

		t1.start();
		t2.start();
	}
}
