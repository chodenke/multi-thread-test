package com.codeke.test.test1;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 15:11
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		/**
		 * 设计意图，t2线程监控listAdd1中的size，t1线程不断往listAdd1中添加元素（10个）
		 * 当t2线程检测到list的size为5时，t2线程抛异常退出
		 *
		 * 下面的代码能够完成设计意图，但是在t2线程中用一个while循环一直检测是一种非常耗费性能的做法，有没有更好的办法呢？看test2吧
		 */


		ListAdd1 listAdd1 = new ListAdd1();

		Thread t1 = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					listAdd1.add();
					System.out.println("当前线程：" + currentThread().getName() + "添加了一个元素..");
					sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1");

		Thread t2 = new Thread(() -> {
			while (true){
				if (listAdd1.size() == 5){
					System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
					throw new RuntimeException();
				}
			}
		}, "t2");

		t2.start();
		try {
			sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();

	}

}
