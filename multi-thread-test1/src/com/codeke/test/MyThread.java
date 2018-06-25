package com.codeke.test;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 10:22
 * @description
 */
public class MyThread extends Thread {

	private static int count = 5;

	@Override
	public /*synchronized*/ void run() {
		count--;
		System.out.println(this.currentThread().getName() + ", count = " + count);
	}

}
