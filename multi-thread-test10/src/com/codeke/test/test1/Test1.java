package com.codeke.test.test1;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 17:00
 * @description
 */
public class Test1 {

	public static void main(String[] args) {
		ConnThreadLocal ct = new ConnThreadLocal();

		Thread t1 = new Thread(() -> {
			ct.setTh("张三");
			ct.getTh();
		}, "t1");

		Thread t2 = new Thread(() -> {
			try {
				sleep(1000);
				ct.getTh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2");

		t1.start();
		t2.start();

	}

}
