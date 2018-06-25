package com.codeke.test.test2;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 11:36
 * @description 锁对象的改变问题
 */
public class ChangeLock {

	private String lock = "lock";

	public void method1(){
		synchronized (lock) {
			try {
				System.out.println("当前线程 : "  + currentThread().getName() + "开始");
				lock = "change lock";  // 改了就相当于换了一把锁
				sleep(2000);
				System.out.println("当前线程 : "  + currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void method2(){
		synchronized ("lock") {
			try {
				System.out.println("当前线程 : "  + currentThread().getName() + "开始");
				sleep(2000);
				System.out.println("当前线程 : "  + currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
