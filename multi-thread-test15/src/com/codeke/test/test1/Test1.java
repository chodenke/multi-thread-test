package com.codeke.test.test1;

import java.util.Random;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-29 11:41
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		// workerCount 控制有多少个线程
		Master master = new Master(new Worker(), 4000);

		Random r = new Random();
		for (int i = 0; i < 10000; i++) { //循环变量控制有多少任务
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}

		long start = System.currentTimeMillis();

		master.execute();

		while (true) {
			if(master.isComplate()){
				long end = System.currentTimeMillis();
				int priceResult = master.getResult();
				System.out.println("最终结果：" + priceResult + " 共用时：" + (end - start) + "ms");
				break;
			}
		}

	}
}
