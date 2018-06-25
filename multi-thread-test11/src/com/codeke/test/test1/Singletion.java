package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 17:03
 * @description
 */
public class Singletion {

	private static class InnerSingletion {
		private static Singletion single = new Singletion();
	}

	public static Singletion getInstance(){
		return InnerSingletion.single;
	}

}
