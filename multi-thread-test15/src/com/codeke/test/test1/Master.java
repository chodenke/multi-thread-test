package com.codeke.test.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-29 11:02
 * @description
 */
public class Master {

	// 盛放任务的容器
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

	// 盛放worker的容器
	private HashMap<String, Thread> workers = new HashMap<>();

	// 盛放结果的容器
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

	// 构造方法
	public Master(Worker worker, int workerCount){
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for (int i = 0; i < workerCount; i++) {
			this.workers.put("" + i, new Thread(worker));
		}
	}

	//提交任务的方法
	public void submit(Task task){
		this.workQueue.add(task);
	}

	// 执行的方法,启动所有workers去执行任务
	public void execute() {
		workers.forEach((k,v) -> v.start());
	}

	// 判断是否执行结束
	public boolean isComplate(){
		for(Map.Entry<String, Thread> me : workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}

	// 计算结果的方法
	public int getResult(){
		int priceResult = 0;
		for(Map.Entry<String, Object> me : resultMap.entrySet()){
			priceResult += (Integer)me.getValue();
		}
		return priceResult;
	}



}
