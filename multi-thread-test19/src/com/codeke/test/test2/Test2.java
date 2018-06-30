package com.codeke.test.test2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 11:36
 * @description
 */
public class Test2 {

	public static void main(String[] args) {


		/**
		 * CyclicBarrier是一个同步工具类，它允许一组线程互相等待，直到到达某个公共屏障点。
		 * 与CountDownLatch不同的是该barrier在释放等待线程后可以重用，所以称它为循环（Cyclic）的屏障（Barrier）。
		 *
		 * 比较
		 * CountDownLatch:一个线程(或者多个)，等待另外N个线程完成某个事情之后才能执行；CyclicBarrier:N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
		 * CountDownLatch:一次性的；CyclicBarrier:可以重复使用。
		 * CountDownLatch基于AQS；CyclicBarrier基于锁和Condition。本质上都是依赖于volatile和CAS实现的。
		 */

		CyclicBarrier barrier = new CyclicBarrier(3);  // 3
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.submit(new Thread(new Runner(barrier, "张三")));
		executor.submit(new Thread(new Runner(barrier, "李四")));
		executor.submit(new Thread(new Runner(barrier, "王五")));

		executor.shutdown();


	}

}
