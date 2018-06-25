package com.codeke.test.test1;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 16:59
 * @description
 */
public class ConnThreadLocal {

	public static ThreadLocal<String> th = new ThreadLocal<String>();

	public void setTh(String value){
		th.set(value);
	}

	public void getTh(){
		System.out.println(currentThread().getName() + ":" + this.th.get());
	}

}
