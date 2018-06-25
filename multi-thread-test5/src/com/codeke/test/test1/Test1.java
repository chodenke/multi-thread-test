package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 16:06
 * @description
 */
public class Test1 {

	public static void main(String[] args) {
		SyncDubbo1 syncDubbo1 = new SyncDubbo1();
		Thread t1 = new Thread(syncDubbo1::method1,"t1");
		Thread t2 = new Thread(syncDubbo1::method1,"t2");
		t1.start();
		t2.start();
	}
}
