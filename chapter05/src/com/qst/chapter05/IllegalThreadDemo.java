package com.qst.chapter05;

public class IllegalThreadDemo {

	public static void main(String[] args) {
		// 创建线程
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i);
				}
			}
		});
		// 多次启动线程将引发IllegalThreadStateException异常
		t.start();
		t.start();
	}

}
