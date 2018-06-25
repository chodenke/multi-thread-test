package com.codeke.test.test2;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 16:08
 * @description
 */
public class Sup {

	public int i = 10;

	public synchronized void operationSup(){
		try {
			i--;
			System.out.println(currentThread().getName() + " Sup print i = " + i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
