package com.codeke.test;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-22 15:04
 * @description
 */
public class Test {

	public static void main(String[] args) {

		DirtyRead dr = new DirtyRead();

		Thread t1 = new Thread(dr::getValue);
		t1.start();
		dr.setValue("ekedong","456");

		/**
		 * 业务整体需要使用完整的synchronized，保持业务的原子性。
		 * setValue和getValue方法没有加synchronized，或只有其中一个方法加了synchronized时，业务不能保持原子性，出现的结果
		 * getValue方法得到：username = ekedong , password = 123
		 * setValue最终结果：username = ekedong , password = 456
		 *
		 * setValue和getValue方法都加synchronized时
		 * setValue最终结果：username = ekedong , password = 456
		 * getValue方法得到：username = ekedong , password = 456
		 */


	}
}
