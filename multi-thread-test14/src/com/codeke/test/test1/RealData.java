package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 11:31
 * @description
 */
public class RealData implements Data {

	private String result;

	public RealData(String queryStr) {
		System.out.println("根据" + queryStr + "进行查询，这是一个很耗时的操作..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("操作完毕，获取结果");
		result = "查询结果";
	}

	@Override
	public String getRequest() {
		return result;
	}
}
