package com.codeke.test.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 15:36
 * @description
 */
public class ListAdd3 {

	private volatile List list = new ArrayList();

	public void add(){
		list.add("codeke");
	}
	public int size(){
		return list.size();
	}

}
