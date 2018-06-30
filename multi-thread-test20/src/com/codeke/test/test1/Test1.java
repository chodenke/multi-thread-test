package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 14:51
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		/**
		 * 重入锁测试，没有得到想要的结果啊
		 */

		ReentrantLockUser lockUser = new ReentrantLockUser();

		lockUser.method1();
		lockUser.method2();

		new Thread(() -> {

		},"t1").start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//System.out.println(lockUser.lock.getQueueLength());
	}

}
