package com.codeke.test.test5;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:26
 * @description
 */
public class Test5 {

	public static void main(String[] args) {

		/**
		 * LinkedBlockingDeque就是一个双端队列，任何一端都可以进行元素的出入
		 */

		LinkedBlockingDeque<String> dq = new LinkedBlockingDeque<>();

		dq.addFirst("a");
		dq.addFirst("b");
		dq.addFirst("c");
		dq.addFirst("d");
		dq.addFirst("e");
		dq.addLast("f");
		dq.addLast("g");
		dq.addLast("h");
		dq.addLast("i");
		dq.addLast("j");

		System.out.println("查看头元素：" + dq.peekFirst());
		System.out.println("获取尾元素：" + dq.pollLast());

		dq.forEach(System.out::println);



	}
}
