package com.codeke.test.test1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-29 10:37
 * @description
 */

// worker要运行在线程中，故这里实现了Runnable接口
public class Worker implements Runnable {

	private ConcurrentLinkedQueue<Task> workQueue;  // 用来放任务的队列
	private ConcurrentHashMap<String, Object> resultMap; // 用来放结果的map

	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		while (true){ //循环从队列中取任务
			Task task = this.workQueue.poll(); //取任务并移除
			if (task == null) { //没取到时就该跳出循环了
				break;
			}
			// 处理task
			Object result = handle(task);
			// 将结果放入resultMap
			this.resultMap.put("" + task.getId(), result);
		}
	}


	private Object handle(Task task){
		Object output = null;
		try {
			// 处理一个比较耗时的任务
			sleep(500);
			output = task.getPrice();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output;
	}



}
