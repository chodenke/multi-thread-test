package com.codeke.test.test1;

import static java.lang.Thread.sleep;

/**
 * @company: 甘肃诚诚网络技术有限公司
 * @author: codeke
 * @date: 2018-06-30 9:48
 * @description
 */
public class Task implements Runnable {

	private int taskId;
	private String taskName;

	public Task(int taskId, String taskName) {
		this.taskId = taskId;
		this.taskName = taskName;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println("run taskId =" + this.taskId);
			sleep(5000);
			System.out.println("end taskId =" + this.taskId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Task{" +
				"taskId=" + taskId +
				", taskName='" + taskName + '\'' +
				'}';
	}
}
