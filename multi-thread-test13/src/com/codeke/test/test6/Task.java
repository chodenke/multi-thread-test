package com.codeke.test.test6;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:29
 * @description
 */
public class Task implements Comparable<Task> {

	private int id ;
	private String name;

	public Task(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int compareTo(Task o) {
		return this.id > o.id ? 1 : (this.id < o.id ? -1 : 0);
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
