package com.codeke.test.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 10:23
 * @description
 */
public class VolatileNoAtomic extends Thread{

	// private static volatile int count;
	// volatile 不能保证原子性，测试结果有可能最后输出不是10000，
	// 解决方法：1.addCount()方法加synchronized;  2.如下，使用AtomicInteger,这种方法性能更高

	private static AtomicInteger count = new AtomicInteger(0);

	private static void addCount(){
		for (int i = 0; i < 1000; i ++){
			// count ++;
			count.incrementAndGet();
		}
		System.out.println("count = " + count);
	}

	@Override
	public void run() {
		addCount();
	}
}
