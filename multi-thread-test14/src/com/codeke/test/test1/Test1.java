package com.codeke.test.test1;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 11:52
 * @description
 */
public class Test1 {

	public static void main(String[] args) {

		FutureClient futureClient = new FutureClient();
		Data data = futureClient.request("	请求");

		try {
			System.out.println("Test1.main 去做其他的事情");
			sleep(4000);
			System.out.println("Test1.main 其他的事情做完了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String result = data.getRequest();
		System.out.println(result);

	}


}
