package com.codeke.test.test1;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 11:21
 * @description
 */
public class StringLock {

	/**
	 * synchronized代码块对字符串的锁，注意String常量池的缓存功能
	 */

	public void method() {
		//new String("字符串常量")
		synchronized ("字符串常量") {
			try {
				while(true){
					System.out.println("当前线程 : "  + currentThread().getName() + "开始");
					Thread.sleep(1000);
					System.out.println("当前线程 : "  + currentThread().getName() + "结束");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
