package com.qst.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//通过使用Callable和Future接口来创建线程
//这个方式的优点：可以在线程执行完任务后获取执行结果。

//1. 创建Callable接口的实现类
class Task implements Callable<Integer> {

	// 实现call()方法，作为线程执行体
	public Integer call() throws Exception {

		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
		// call()方法可以有返回值
		return i;
	}

}

public class CallableFutureDemo {

	public static void main(String[] args) {

		// 2.使用FutureTask类包装Callable实现类的实例
		FutureTask<Integer> task = new FutureTask<Integer>(new Task());

		// 3.创建线程,使用FutureTask对象task作为Thread对象的targer,并调用start()方法启动线程
		new Thread(task, "子线程").start();

		// 4.调用FutrueTask对象task的get()方法获取子线程执行结束后的返回值
		try {
			System.out.println("子线程返回值：" + task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// 主线程任务
		for (int i = 1000; i < 1100; i++) {
			// 使用Thread.currentThread().getName()获取主线程名字
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

}
