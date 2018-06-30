package com.codeke.test.test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 14:52
 * @description
 */
public class ReentrantLockUser {

	public ReentrantLock lock = new ReentrantLock();

	public void method1(){
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1..");
			Thread.sleep(5000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1..");
			Thread.sleep(5000);
			System.out.println(lock.getHoldCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void method2(){
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2..");
			Thread.sleep(2000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2..");
			Thread.sleep(1000);
			System.out.println(lock.getHoldCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
