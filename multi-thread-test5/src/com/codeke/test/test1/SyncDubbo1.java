package com.codeke.test.test1;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 16:04
 * @description 测试synchronized的重入，同一实例的多个synchronized方法可以重入，并且保证线程安全
 */
public class SyncDubbo1 {

	public synchronized void method1(){
		System.out.println(currentThread().getName() + " method1..");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		method2();
	}
	public synchronized void method2(){
		System.out.println(currentThread().getName() + " method2..");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		method3();
	}
	public synchronized void method3(){
		System.out.println(currentThread().getName() + " method3..");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
