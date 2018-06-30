package com.codeke.test.test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:52
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		/**
		 * 在使用有界队列时，若有新的任务需要执行，如果线程池实际线程数小于corePoolSize，则优先创建线程，
		 * 若大于corePoolSize，则会将任务加入队列，
		 * 若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程，
		 * 若线程数大于maximumPoolSize，则执行拒绝策略。或其他自定义方式。
		 *
		 */
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				1, 				//coreSize
				2, 				//MaxSize
				60, 			//60
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3)			//指定一种队列 （有界队列）
				//new LinkedBlockingQueue<Runnable>()
				, new MyRejected()
				//, new DiscardOldestPolicy()
		);

		Task t1 = new Task(1, "任务1");
		Task t2 = new Task(2, "任务2");
		Task t3 = new Task(3, "任务3");
		Task t4 = new Task(4, "任务4");
		Task t5 = new Task(5, "任务5");
		Task t6 = new Task(6, "任务6");


		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);

		pool.shutdown();

	}
}
