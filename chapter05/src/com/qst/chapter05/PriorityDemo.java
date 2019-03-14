package com.qst.chapter05;

class MyPriorityThread extends Thread {
	public MyPriorityThread(String name) {
		super(name);
	}

	public void run() {

		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + ",其优先级是：" + this.getPriority()
					+ ",循环变量的值为:" + i);
		}
	}
}

public class PriorityDemo {

	public static void main(String[] args) {
		//输出主线程的优先级
		System.out.println(Thread.currentThread().getPriority());
		//创建子线程,并设置不同优先级
		MyPriorityThread t1=new MyPriorityThread("高级");
		t1.setPriority(Thread.MAX_PRIORITY);
		
		MyPriorityThread t2=new MyPriorityThread("普通");
				
		MyPriorityThread t3=new MyPriorityThread("低级");
		t3.setPriority(Thread.MIN_PRIORITY);
		
		MyPriorityThread t4=new MyPriorityThread("指定值");
		t4.setPriority(8);
		
		//启动所有子线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
