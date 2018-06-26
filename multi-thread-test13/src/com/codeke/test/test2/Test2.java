package com.codeke.test.test2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-26 14:26
 * @description
 */
public class Test2 {

	public static void main(String[] args) {


		/**
		 * 并发编程实践中，ConcurrentHashMap是一个经常被使用的数据结构，
		 * 相比于Hashtable以及Collections.synchronizedMap()，
		 * ConcurrentHashMap在线程安全的基础上提供了更好的写并发能力，但同时降低了对读一致性的要求（这点好像CAP理论啊 O(∩_∩)O）。
		 * ConcurrentHashMap的设计与实现非常精巧，大量的利用了volatile，final，CAS等lock-free技术来减少锁竞争对于性能的影响，
		 * 无论对于Java并发编程的学习还是Java内存模型的理解，ConcurrentHashMap的设计以及源码都值得非常仔细的阅读与揣摩。
		 *
		 * ConcurrentHashMap 核心思想： jdk8以前分段锁，1.8以后有巨大改动，值得研究
		 */

		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");

		map.put("k3", "v4");  //存入，有则覆盖
		map.putIfAbsent("k4", "v4");  //没有则存入，有则不存

		System.out.println(map.get("k3"));

		map.forEach((k,v) -> System.out.println("k=" + k + ", v=" + v));



	}
}
