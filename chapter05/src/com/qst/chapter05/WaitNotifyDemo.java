package com.qst.chapter05;

//产品
class Product {
	int n;
	// 为true时表示有值可取，为false时表示需要放入新值
	boolean valueSet = false;

	// 生产方法		补充：也是同步方法实现线程同步	wait()	notify()用于线程通信，请参考pv操作（这里的wait仅仅是p操作中的阻塞过程，信号量的控制仍然要我们自己来定义，所以请参考），这里的valueSet就是信号量。
	synchronized void put(int n) {
		// 如果没有值，等待线程取值
		if (valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.n = n;
		// 将valueSet设置为true，表示值已放入
		valueSet = true;
		System.out.println(Thread.currentThread().getName() + "-生产:" + n);
		// 通知等待线程，进行取值操作
		notify();
	}

	// 消费方法		补充：同步方法 实现线程同步。
	synchronized void get() {
		// 如果没有值，等待新值放入
		if (!valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + "-消费:" + n);
		// 将valueSet设置为false，表示值已取
		valueSet = false;
		// 通知等待线程，放入新值
		notify();
	}
}

// 生产者		补充：线程类
class Producer implements Runnable {
	Product product;

	Producer(Product product) {
		this.product = product;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int k = 0;
		// 生产10次
		for (int i = 0; i < 10; i++) {
			product.put(k++);
		}
	}
}

// 消费者		补充：线程类
class Consumer implements Runnable {
	Product product;

	Consumer(Product product) {
		this.product = product;
		//补充：注意这里直接启动了线程
		new Thread(this, "Consumer").start();
	}

	public void run() {
		// 消费10次
		for (int i = 0; i < 10; i++) {
			product.get();
		}
	}
}

public class WaitNotifyDemo {
	public static void main(String args[]) {
		// 实例化一个产品对象，生产者和消费者共享该实例
		Product product = new Product();
		// 指定生产线程
		Producer producer = new Producer(product);
		// 指定消费线程
		Consumer consumer = new Consumer(product);
	}
}
