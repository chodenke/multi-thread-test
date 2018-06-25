package com.codeke.test.test6;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:16
 * @description
 */
public class Test6 {

	public static void main(String[] args) {

		/**
		 * 使用synchronized代码块减小锁的粒度，提高性能
		 */

		Optimize optimize = new Optimize();

		Thread t1 = new Thread(optimize::doLongTimeTask, "t1");
		Thread t2 = new Thread(optimize::doLongTimeTask, "t2");

		t1.start();
		t2.start();


	}

}
