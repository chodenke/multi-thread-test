package com.codeke.test.test6;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:29
 * @description
 */
public class Test6 {

	public static void main(String[] args) throws InterruptedException {

		/**
		 * 具有优先级的队列，需要实现Comparable接口
		 */

		PriorityBlockingQueue<Task> pq = new PriorityBlockingQueue<>();

		Task task1 = new Task(1, "张三");
		Task task2 = new Task(2, "李四");
		Task task3 = new Task(3, "王五");
		Task task4 = new Task(4, "马六");

		pq.add(task3);
		pq.add(task1);
		pq.add(task4);
		pq.add(task2);

		System.out.println("------------------------------------");
		System.out.println(pq);
		pq.forEach(System.out::println);
		System.out.println("------------------------------------");
		System.out.println(pq.take());
		System.out.println(pq);
		pq.forEach(System.out::println);
		System.out.println("------------------------------------");
		System.out.println(pq.take());
		System.out.println(pq);
		pq.forEach(System.out::println);
		System.out.println("------------------------------------");


	}
}
