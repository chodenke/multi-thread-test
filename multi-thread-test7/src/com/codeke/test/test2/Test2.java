package com.codeke.test.test2;

import java.util.Arrays;
import java.util.List;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 10:29
 * @description
 */
public class Test2 {

	public static void main(String[] args) {
		VolatileNoAtomic[] arr = new VolatileNoAtomic[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new VolatileNoAtomic();
		}

		List<VolatileNoAtomic> volatileNoAtomicList = Arrays.asList(arr);
		volatileNoAtomicList.forEach(Thread::start);

	}

}
