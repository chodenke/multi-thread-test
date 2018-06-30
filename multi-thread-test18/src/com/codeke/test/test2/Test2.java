package com.codeke.test.test2;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:55
 * @description
 */
public class Test2 {

	public static void main(String[] args) throws InterruptedException {

		/**
		 * 无界的任务队列 LinkedBlockingQueue
		 * 与有界队列相比，除非系统资源耗尽，否则无界的任务队列不存在任务入队失败的情况
		 * 当有新任务到来时，系统的线程数少于corePoolSize时，则新建线程执行任务
		 * 当到达corePoolSize后，就不会继续增加。若后续仍有新的任务加入，而又没有空闲的线程资源，则任务直接进入线程等待
		 * 若任务创建和处理的速度差异很大，无界队列会保持快速增长，指导耗尽系统资源
		 */

		BlockingQueue<Runnable> queue =
				new LinkedBlockingQueue<Runnable>();
		ExecutorService executor  = new ThreadPoolExecutor(
				5, 		//core
				5, 	//max   使用无界队列时，corePoolSize和maximumPoolSize一般设置为一样的，maximumPoolSize设置大并没有实际的意义
				120L, 	//2fenzhong
				TimeUnit.SECONDS,
				queue);

		for(int i = 0 ; i < 20; i++){
			executor.execute(new Task());
		}
		sleep(1000);
		System.out.println("queue size:" + queue.size());		//10
		sleep(2000);

	}
}
