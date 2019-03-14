package com.qst.chapter05;
//主线程：每个进程都至少包含一个主线程，而main方法中执行的就是主线程执行的任务。

public class MainThreadDemo {
	// main()方法
	public static void main(String args[]) {
		// 调用Thread类的currentThread()方法获取当前线程		补充：Thread Thread.currentThread()	作用：获取主线程。
		Thread t = Thread.currentThread();
		// 设置线程名										补充个：t.setName(String name)	作用：设置线程名称。
		t.setName("MyMainThread");
		// 输出线程信息
		System.out.println("主线程是: " + t);
		// 获取线程Id	
		System.out.println("线程ID：" + t.getId());
		// 获取线程名
		System.out.println("线程名：" + t.getName());
	}
}
