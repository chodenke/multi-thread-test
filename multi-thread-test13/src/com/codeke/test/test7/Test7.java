package com.codeke.test.test7;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:47
 * @description
 */
public class Test7 {

	public static void main(String[] args) {
		System.out.println("网吧开始营业");
		WangBa wangBa = new WangBa();
		Thread shangwang = new Thread(wangBa);
		shangwang.start();

		wangBa.shangji("张三","123",2);
		wangBa.shangji("李四","234",10);
		wangBa.shangji("王五","345",6);
		wangBa.shangji("马六","456",4);
	}
}
