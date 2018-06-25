package com.codeke.test.test4;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:07
 * @description 同一对象属性的修改不会影响锁的情况
 */
public class ModifyLock {

	private String name ;
	private int age ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public synchronized void changeAttributte(String name, int age) {
		try {
			System.out.println("当前线程 : "  + currentThread().getName() + " 开始");
			this.setName(name);
			this.setAge(age);

			System.out.println("当前线程 : "  + currentThread().getName() + " 修改对象内容为： "
					+ this.getName() + ", " + this.getAge());

			Thread.sleep(2000);
			System.out.println("当前线程 : "  + currentThread().getName() + " 结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
