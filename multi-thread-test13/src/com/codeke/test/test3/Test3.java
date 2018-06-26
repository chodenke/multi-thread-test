package com.codeke.test.test3;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-26 14:38
 * @description
 */
public class Test3 {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>();
		CopyOnWriteArraySet<String> cowas = new CopyOnWriteArraySet<>();

		cowal.add("cowal1");
		cowal.add("cowal2");
		cowal.add("cowal3");
		cowal.add("cowal4");
		cowal.add("cowal5");
		cowal.addIfAbsent("cowal1"); // 没有则存入，有则不存

		cowal.forEach(System.out::println);


		System.out.println("===================================================");

		cowas.add("cowas1");
		cowas.add("cowas2");
		cowas.add("cowas3");
		cowas.add("cowas4");
		cowas.add("cowas5");
		cowas.add("cowas1");

		cowas.forEach(System.out::println);

	}

}
