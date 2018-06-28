package com.codeke.test.test7;

import java.util.concurrent.DelayQueue;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:40
 * @description
 */
public class WangBa implements Runnable {

	private DelayQueue<WangMin> queue = new DelayQueue<WangMin>();

	public volatile boolean yinye = true;

	public void shangji(String name, String id, int money){
		WangMin man = new WangMin(name, id, 1000 * money + System.currentTimeMillis());
		System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块,开始上机...");
		this.queue.add(man);
	}

	public void xiaji(WangMin man){
		System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"时间到下机...");
	}

	@Override
	public void run() {
		while(yinye){
			try {
				WangMin man = queue.take();
				xiaji(man);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
