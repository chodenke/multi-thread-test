package com.codeke.test.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 10:47
 * @description
 */
public class Test3 {

	public static void main(String[] args) {
		AtomicUse atomicUse = new AtomicUse();

		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			ts.add(new Thread(() -> {System.out.println(atomicUse.multiAdd());}));
		}
		ts.forEach(Thread::start);
	}

}
