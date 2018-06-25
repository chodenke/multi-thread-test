package com.codeke.test.test1;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-25 15:56
 * @description
 */
public class MyQueue<T> {

	// 需要一个承装元素的集合
	private LinkedList<T> list = new LinkedList<T>();

	// 需要一个计数器
	private AtomicInteger count = new AtomicInteger(0);

	// 需要指定上线和下线
	private final int minSize = 0;
	private final int maxSize;

	// 构造方法
	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	// 初始化一个锁对象
	Object lock = new Object();

	//put(anObject): 把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断，直到BlockingQueue里面有空间再继续.
	public void put(T t){
		synchronized (lock) {
			while (this.count.get() == this.maxSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 1.加入元素
			list.add(t);
			// 2.计数器累加
			this.count.incrementAndGet();
			// 3.通知（唤醒）另外一个线程
			lock.notify();
			System.out.println("当前线程：" + currentThread().getName() + " 新加入的元素为" + t);
		}
	}

	//take: 取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到BlockingQueue有新的数据被加入.
	public T take() {
		T t = null;
		synchronized (lock){
			while(this.count.get() == this.minSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 1.获取并移除元素
			t = list.removeFirst();
			// 2.技术器递减
			count.decrementAndGet();
			// 3.唤醒另外的线程
			lock.notify();
		}
		return t;
	}

	public int getSize(){
		return this.count.get();
	}

}
