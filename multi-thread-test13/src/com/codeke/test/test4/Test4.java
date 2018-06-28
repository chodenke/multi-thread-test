package com.codeke.test.test4;

import java.util.concurrent.SynchronousQueue;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-26 14:50
 * @description
 */
public class Test4 {

	public static void main(String[] args) {

		// ===================================================================================
		/**
		 * ConcurrentLinkedQueue 高性能无阻塞无界队列
		 */
		// ConcurrentLinkedQueue<String> q1 = new ConcurrentLinkedQueue<>();
		// q1.offer("a");
		// q1.offer("b");
		// q1.offer("c");
		// q1.offer("d");
		// q1.offer("e");
		// q1.offer("f");
		// q1.add("g");
		//
		// System.out.println(q1.size());
		// System.out.println(q1.poll());  // 从头部取出，并从队列中移除
		// System.out.println(q1.size());
		//
		// System.out.println(q1.peek());  // 从队列中读取，不从队列中移除
		// System.out.println(q1.size());
		//
		// System.out.println(q1.peek());
		// System.out.println(q1.size());
		// ===================================================================================


		// ===================================================================================
		/**
		 * ArrayBlockingQueue 阻塞有界队列
		 * add offer put 是插入的操作
		 * *add: 内部实际上获取的offer方法，当Queue已经满了时，抛出一个异常。不会阻塞
		 * *offer:当Queue已经满了时，返回false。不会阻塞
		 * *put:当Queue已经满了时，会进入等待，只要不被中断，就会插入数据到队列中。会阻塞，可以响应中断
		 * remove,poll,take,peek是取出的操作
		 * *remove和add相互对应。也就是说，调用remove方法时，假如对列为空，则抛出一场
		 * *poll与offer相互对应
		 * *take和put相互对应
		 * *前三个取出的方法，都会将元素从Queue的头部移除，但是peek不会，实际上只是，获取队列头的元素。peek方法也不会阻塞。当队列为空时，直接返回Null。
		 */
		// ArrayBlockingQueue<String> q2 = new ArrayBlockingQueue<String>(5);  // 必须在初始化时指定队列长度
		// try {
		// 	q2.put("a");
		// 	System.out.println(q2.poll());
		// 	q2.put("b");
		// 	q2.put("c");
		// 	q2.put("d");
		// 	q2.put("e");
		// 	q2.put("f");
		//
		// 	System.out.println(q2.offer("g", 1, TimeUnit.SECONDS));
		// 	q2.forEach(System.out::println);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		// ===================================================================================


		// ===================================================================================
		/**
		 * LinkedBlockingQueue 阻塞无界队列
		 * LinkedBlockingQueue构造的时候若没有指定大小，则默认大小为Integer.MAX_VALUE
		 * 添加元素的方法有三个：add,put,offer,且这三个元素都是向队列尾部添加元素的意思。
		 * *add方法在添加元素的时候，若超出了度列的长度会直接抛出异常
		 * *put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素
		 * *offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false
		 * 从队列中取出并移除头元素的方法有：poll，remove，take
		 * *poll: 若队列为空，返回null
		 * *remove:若队列为空，抛出NoSuchElementException异常
		 * *take:若队列为空，发生阻塞，等待有元素
		 *
		 * 另外，还有一个drainTo()方法
		 * 一次性从BlockingQueue获取所有可用的数据对象（还可以指定获取数据的个数）,
		 * 通过该方法，可以提升获取数据效率；不需要多次分批加锁或释放锁。
		 */
		// LinkedBlockingQueue<String> q3 = new LinkedBlockingQueue<>();
		// q3.offer("a");
		// q3.offer("b");
		// q3.offer("c");
		// q3.offer("d");
		// q3.offer("e");
		// q3.add("g");
		//
		// System.out.println(q3.size());
		//
		// q3.forEach(System.out::println);
		//
		// List<String> list = new ArrayList<String>();
		// System.out.println(q3.drainTo(list, 3));
		//
		// System.out.println(list.size());
		// list.forEach(System.out::println);
		// ===================================================================================


		// ===================================================================================
		/**
		 * SynchronousQueue没有容量。
		 * 与其他BlockingQueue不同，SynchronousQueue是一个不存储元素的BlockingQueue。
		 * 每一个put操作必须要等待一个take操作，否则不能继续添加元素，反之亦然。
		 *
		 * 因为没有容量，所以对应 peek, contains, clear, isEmpty … 等方法其实是无效的。
		 * 例如clear是不执行任何操作的，contains始终返回false,peek始终返回null。
		 *
		 * SynchronousQueue分为公平和非公平，默认情况下采用非公平性访问策略，当然也可以通过构造函数来设置为公平性访问策略（为true即可）
		 *
		 * SynchronousQueue非常适合做交换工作，生产者的线程和消费者的线程同步以传递某些信息、事件或者任务
		 */

		SynchronousQueue<String> q4 = new SynchronousQueue<>();

		Thread t1 = new Thread(() -> {
			try {
				System.out.println(q4.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1");
		t1.start();

		Thread t2 = new Thread(() -> {
			try {
				q4.put("hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2");

		t2.start();


	}

}
