package com.codeke.test.test6;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:15
 * @description 使用synchronized代码块减小锁的粒度，提高性能
 */
public class Optimize {

	public void doLongTimeTask(){
		try {

			System.out.println("当前线程开始：" + currentThread().getName() +
					", 正在执行一个较长时间的业务操作，其内容不需要同步");
			Thread.sleep(2000);

			synchronized(this){
				System.out.println("当前线程：" + currentThread().getName() +
						", 执行同步代码块，对其同步变量进行操作");
				Thread.sleep(1000);
			}
			System.out.println("当前线程结束：" + currentThread().getName() +
					", 执行完毕");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
