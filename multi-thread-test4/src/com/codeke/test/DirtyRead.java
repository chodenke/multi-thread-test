package com.codeke.test;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 15:08
 * @description 业务整体需要使用完整的synchronized，保持业务的原子性。
 */
public class DirtyRead {

	private String username = "codeke";
	private String password = "123";

	public synchronized void setValue(String username, String password){
		this.username = username;

		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.password = password;

		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}

	public synchronized void getValue(){
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
	}

}
