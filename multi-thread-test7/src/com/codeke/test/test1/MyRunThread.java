package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 17:22
 * @description
 */
public class MyRunThread extends Thread {

	// volatile 关键字用于强制线程使用主内存中的数据
	private volatile boolean isRunning = true;

	public void setRunning(boolean running) {
		isRunning = running;
	}

	public void run(){
		System.out.println("进入run方法");
		while(isRunning){
			/**
			 * 这里加上一些代码后，测试效果达不到了，网上查到的原因如下，不知对否
			 * 对于非volatile修饰的变量，尽管jvm的优化，会导致变量的可见性问题，
			 * 但这种可见性的问题也只是在短时间内高并发的情况下发生，CPU执行时会很快刷新Cache，一般的情况下很难出现，
			 * 而且出现这种问题是不可预测的，与jvm, 机器配置环境等都有关。
			 */
		}
		System.out.println("线程停止");
	}
}
