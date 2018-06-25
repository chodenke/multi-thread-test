package com.codeke.test.test2;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 16:10
 * @description
 */
public class Test2 {



	public static void main(String[] args) {

		/**
		 * synchronized的重入,子类与父类之间也可以重入，保证线程安全
		 */
		Sub sub = new Sub();
		Thread t1 = new Thread(sub::operationSub, "t1");
		Thread t2 = new Thread(sub::operationSub, "t2");
		t1.start();
		t2.start();
	}
}
