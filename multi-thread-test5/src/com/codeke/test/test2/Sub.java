package com.codeke.test.test2;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 16:09
 * @description
 */
public class Sub extends Sup {

	public synchronized void operationSub(){
		try {
			while(i > 0) {
				i--;
				System.out.println(currentThread().getName() + " Sub print i = " + i);
				Thread.sleep(100);
				this.operationSup();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
