package com.qst.chapter05;

//1.继承Thread类			补充：并且重写run方法
public class ThreadDemo extends Thread {
	// 重写run()方法，线程的任务方法，即执行体
	public void run() {

		for (int i = 0; i < 100; i++) {
			// 继承Thread类时，直接使用this即可获取当前线程对象
			// 调用getName()方法返回当前线程的名字
			System.out.println(this.getName() + " : " + i);
		}
	}

	public static void main(String[] args) {
		// 2.创建线程对象
		ThreadDemo td = new ThreadDemo();
		// 3.调用start()方法启动线程
		td.start();

		// 主线程任务
		for (int i = 1000; i < 1100; i++) {
			// 使用Thread.currentThread().getName()获取主线程名字
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}
