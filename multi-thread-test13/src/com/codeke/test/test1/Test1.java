package com.codeke.test.test1;

import java.util.concurrent.TimeUnit;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-26 9:25
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		TimeUnit timeUnit = TimeUnit.DAYS;

		System.out.println(timeUnit.name());
		System.out.println(timeUnit.toDays(1));
		System.out.println(timeUnit.toHours(1));
		System.out.println(timeUnit.toMinutes(1));
		System.out.println(timeUnit.toSeconds(1));
		System.out.println(timeUnit.toMillis(1));
		System.out.println(timeUnit.toMicros(1));
		System.out.println(timeUnit.toNanos(1));
		System.out.println(timeUnit.convert(1,TimeUnit.DAYS) + " " + timeUnit.name());
		System.out.println(timeUnit.convert(24,TimeUnit.HOURS) + " " + timeUnit.name());
		System.out.println(timeUnit.convert(1440,TimeUnit.MINUTES) + " " + timeUnit.name());

	}

}
