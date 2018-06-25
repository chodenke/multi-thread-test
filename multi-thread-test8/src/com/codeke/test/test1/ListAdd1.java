package com.codeke.test.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 14:27
 * @description
 */
public class ListAdd1 {

	private volatile List list = new ArrayList();

	public void add(){
		list.add("codeke");
	}
	public int size(){
		return list.size();
	}

}
