package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 17:24
 * @description
 */
public class Test1 {

	public static void main(String[] args) throws InterruptedException {

		MyRunThread myRunThread = new MyRunThread();

		myRunThread.start();

		Thread.sleep(4000);
		myRunThread.setRunning(false);
		System.out.println("isRunning的值已经被设置了false");

	}
}
