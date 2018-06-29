package com.codeke.test.test1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-29 12:04
 * @description
 */
// 生产者
public class Provider implements Runnable {

	// 共享缓存区
	private BlockingQueue<Data> queue;

	//多线程间是否启动变量，有强制从主内存中刷新的功能。即时返回线程的状态
	private volatile boolean isRunning = true;

	//id生成器
	private static AtomicInteger count = new AtomicInteger();

	//随机对象
	private static Random r = new Random();

	// 构造方法
	public Provider(BlockingQueue<Data> queue) {
		this.queue = queue;
	}

	// 生产者往缓存区添加数据
	@Override
	public void run() {
		while (this.isRunning) {
			try {
				//随机休眠0 - 1000 毫秒 表示获取数据(产生数据的耗时)
				sleep(r.nextInt(1000));
				//获取的数据进行累计...
				int id = count.incrementAndGet();
				// 构造一条数据
				Data data = new Data("" + id, "数据" + id);

				System.out.println("当前线程:" + Thread.currentThread().getName() + ", 获取了数据，id为:" + id + ", 进行装载到公共缓冲区中...");
				if(!this.queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("提交缓冲区数据失败....");
					//do something... 比如重新提交
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 停止的方法
	public void stop(){
		this.isRunning = false;
	}
}
