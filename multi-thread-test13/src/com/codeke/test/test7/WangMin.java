package com.codeke.test.test7;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-28 10:40
 * @description
 */
public class WangMin implements Delayed {

	private String name;
	//身份证
	private String id;
	//截止时间
	private long endTime;
	//定义时间工具类
	private TimeUnit timeUnit = TimeUnit.SECONDS;

	public WangMin(String name,String id,long endTime){
		this.name=name;
		this.id=id;
		this.endTime = endTime;
	}

	public String getName(){
		return this.name;
	}

	public String getId(){
		return this.id;
	}


	@Override
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		WangMin w = (WangMin)o;
		return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1:0;
	}
}
