package com.codeke.test.test1;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 16:23
 * @description
 */
public class Test1 {

	public static void main(String[] args) {
		MyQueue<String> stringMyQueue = new MyQueue<String>(5);

		stringMyQueue.put("a");
		stringMyQueue.put("b");
		stringMyQueue.put("c");
		stringMyQueue.put("d");
		stringMyQueue.put("e");

		System.out.println("容器的长度为：" + stringMyQueue.getSize());

		Thread t1 = new Thread(() -> {
			stringMyQueue.put("f");
			stringMyQueue.put("g");
		}, "t1");

		Thread t2 = new Thread(() -> {
			String s1 = stringMyQueue.take();
			System.out.println("当前线程：" + currentThread().getName() + " 拿到元素：" + s1);
			String s2 = stringMyQueue.take();
			System.out.println("当前线程：" + currentThread().getName() + " 拿到元素：" + s2);
		}, "t2");


		t1.start();

		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();

	}

}
