package com.codeke.test.test2;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 15:20
 * @description
 */
public class Test2 {

	public static void main(String[] args) {

		/**
		 * 实例化一个对象当作锁，用wait和notify配合synchronized关键字去使用，完成线程间通知
		 * 通知的确是完成了，t2最后也停止了，问题是t2是在t1的10次循环完成之后才退出的，原因就是
		 * wait释放锁，notfiy不释放锁
		 * t2先使用wait开始等待，t1循环5次后notfiy，但是t1并没有释放锁，所以在t1的10次循环结束之后，t2才可以继续
		 * 那怎么办呢，接着看test3
		 */

		ListAdd2 listAdd2 = new ListAdd2();

		Object lock = new Object();

		Thread t1 = new Thread(() -> {
			try {
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						listAdd2.add();
						System.out.println("当前线程：" + currentThread().getName() + " 添加了一个元素..");
						sleep(500);
						if (listAdd2.size() == 5) {
							System.out.println("已经发出通知..");
							lock.notify();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1");


		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				if(listAdd2.size() !=5 ){
					try {
						System.out.println("t2进入...");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("当前线程：" + currentThread().getName() + " 收到通知线程停止..");
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
