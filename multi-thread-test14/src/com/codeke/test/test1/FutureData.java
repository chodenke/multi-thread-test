package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 14:32
 * @description
 */
public class FutureData implements Data {

	private RealData realData;
	private volatile boolean isReady = false;

	public synchronized void setRealData(RealData realData){
		if (isReady){  //已经装载了，就直接返回
			return;
		}
		// 如果没有装载，就装载真实数据
		this.realData = realData;
		isReady = true;
		notify();
	}

	@Override
	public synchronized String getRequest() {
		// 如果没有装载好，程序就一直处于阻塞状态
		while (!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}
}
