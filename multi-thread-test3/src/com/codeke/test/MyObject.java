package com.codeke.test;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 14:35
 * @description
 */
public class MyObject {


	public synchronized void method1(){
		try {
			System.out.println("thread name = " + currentThread().getName());
			sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public /*synchronized*/ void method2(){
		System.out.println("thread name = " + currentThread().getName());
	}
}
