package com.qst.chapter05;

//死亡状态：1.一个线程执行完run或call方法。2.线程抛出异常3.调用stop方法停止线程。
//t.join方法		用于让一个线程等待另一个线程执行完毕后继续执行原线程的任务。
//注意：这里请理解清楚，比如我们在执行某程序中调用其它线程的join()方法，当前线程会被阻塞，直到调用join方法的线程执行完毕为止。
class JoinThread extends Thread {
	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + " : " + i);
		}
	}
}

public class JoinDemo {

	public static void main(String[] args) {

		//创建子线程t1
		JoinThread t1 = new JoinThread("被Join的子线程");
		// 启动t1子线程
		t1.start();
		
		try {
			// 等待t1子线程执行完毕
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 输出主线程名
		System.out.println(Thread.currentThread().getName());

		// t1子线程已经死亡,isAlive()为false
		System.out.println("子线程死亡状态[isAlive: " + t1.isAlive() + "]");
		// 试图再次启动t1子线程，此时t1子线程已经死亡，再次启动将抛出IllegalThreadStateException		补充：不要对死亡状态的线程调用start方法，只能对新建状态的线程调用。
		t1.start();
	}

}
