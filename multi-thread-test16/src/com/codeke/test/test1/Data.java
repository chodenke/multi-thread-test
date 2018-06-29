package com.codeke.test.test1;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-29 12:03
 * @description
 */
public class Data {

	private String id;
	private String name;

	public Data(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Data{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
