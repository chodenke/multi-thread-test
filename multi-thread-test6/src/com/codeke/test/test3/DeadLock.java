package com.codeke.test.test3;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 11:50
 * @description 死锁问题，在设计程序时就应该避免双方相互持有对方的锁的情况
 */
public class DeadLock implements Runnable {

	private String tag;
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public void setTag(String tag){
		this.tag = tag;
	}

	@Override
	public void run() {
		if("a".equals(tag)){
			synchronized (lock1) {
				try {
					System.out.println("当前线程 : "  + currentThread().getName() + " 进入lock1执行");
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("当前线程 : "  + currentThread().getName() + " 进入lock2执行");
				}
			}
		}
		if("b".equals(tag)){
			synchronized (lock2) {
				try {
					System.out.println("当前线程 : "  + currentThread().getName() + " 进入lock2执行");
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("当前线程 : "  + currentThread().getName() + " 进入lock1执行");
				}
			}
		}

	}
}
