package com.codeke.test.test2;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 17:06
 * @description
 */
public class Test2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println(DubbleSingleton.getDs().hashCode());
		}, "t1");
		Thread t2 = new Thread(() -> {
			System.out.println(DubbleSingleton.getDs().hashCode());
		}, "t2");
		Thread t3 = new Thread(() -> {
			System.out.println(DubbleSingleton.getDs().hashCode());
		}, "t3");

		t1.start();
		t2.start();
		t3.start();

	}
}
