package com.codeke.test.test1;

import java.util.Vector;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 17:52
 * @description
 */
public class Tickets {

	public static void main(String[] args) {

		// ArrayList 非线程暗安全
		// List<String> tickets = new ArrayList<String>();

		//初始化火车票池并添加火车票:避免线程同步可采用Vector替代ArrayList  HashTable替代HashMap
		final Vector<String> tickets = new Vector<String>();

		//Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

		for (int i = 1; i <= 10000; i++) {
			tickets.add("火车票" + i);
		}

		for (int i = 1; i <= 100; i++) {
			new Thread(() -> {
				while (true) {
					if (tickets.isEmpty()) break;
					System.out.println(currentThread().getName() + "---" + tickets.remove(0));
				}
			}, "线程" + i).start();
		}
	}
}
