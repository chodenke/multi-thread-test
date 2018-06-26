package com.codeke.test.test4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-26 14:50
 * @description
 */
public class Test4 {

	public static void main(String[] args) {

		// ===================================================================================
		/**
		 * ConcurrentLinkedQueue 高性能无阻塞无界队列
		 */
		// ConcurrentLinkedQueue<String> q1 = new ConcurrentLinkedQueue<>();
		// q1.offer("a");
		// q1.offer("b");
		// q1.offer("c");
		// q1.offer("d");
		// q1.offer("e");
		// q1.offer("f");
		// q1.add("g");
		//
		// System.out.println(q1.size());
		// System.out.println(q1.poll());  // 从头部取出，并从队列中移除
		// System.out.println(q1.size());
		//
		// System.out.println(q1.peek());  // 从队列中读取，不从队列中移除
		// System.out.println(q1.size());
		//
		// System.out.println(q1.peek());
		// System.out.println(q1.size());
		// ===================================================================================


		// ===================================================================================
		/**
		 * ArrayBlockingQueue 阻塞有界队列
		 */
		ArrayBlockingQueue<String> q2 = new ArrayBlockingQueue<String>(5);  // 必须在初始化时指定队列长度
		try {
			q2.put("a");
			System.out.println(q2.poll());
			q2.put("b");
			q2.put("c");
			q2.put("d");
			q2.put("e");
			q2.put("f");

			System.out.println(q2.offer("g", 1, TimeUnit.SECONDS));
			q2.forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
