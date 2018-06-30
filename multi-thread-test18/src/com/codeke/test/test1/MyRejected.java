package com.codeke.test.test1;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:51
 * @description
 */
public class MyRejected implements RejectedExecutionHandler {

	public MyRejected(){
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("自定义处理..");
		System.out.println("当前被拒绝任务为：" + r.toString());
	}

}
