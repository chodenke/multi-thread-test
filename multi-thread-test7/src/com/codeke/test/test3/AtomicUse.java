package com.codeke.test.test3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 10:47
 * @description
 */
public class AtomicUse {

	/**
	 * AtomicInteger可以保证对count每一次操作的原子性，所以main方法中最后测试的结果总是1000
	 * 但是，它并不保证multiAdd方法的原子性，所以在multiAdd方法不加synchronized的情况下，中间会有非整10的数字打印出来
	 * 要保证multiAdd方法的原子性，必须给该方法加synchronized
	 */


	private static AtomicInteger count = new AtomicInteger(0);

	public /*synchronized*/ int multiAdd(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);

		return count.get();
	}

}
