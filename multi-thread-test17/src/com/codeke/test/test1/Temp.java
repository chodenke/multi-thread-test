package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:30
 * @description
 */
public class Temp extends Thread {

	@Override
	public void run() {
		System.out.println(currentThread().getName() + "...run...");
	}

}
