package com.codeke.test.test4;

import java.util.concurrent.Callable;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 13:55
 * @description
 */
public class FutureUser implements Callable<String> {

	private String para;

	public FutureUser(String para) {
		this.para = para;
	}

	/**
	 * 这里是真实的业务逻辑，其执行可能很慢
	 */
	@Override
	public String call() throws Exception {
		//模拟执行耗时
		Thread.sleep(5000);
		String result = this.para + "处理完成";
		return result;
	}
}
