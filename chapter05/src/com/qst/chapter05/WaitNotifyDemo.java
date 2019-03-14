package com.qst.chapter05;

//��Ʒ
class Product {
	int n;
	// Ϊtrueʱ��ʾ��ֵ��ȡ��Ϊfalseʱ��ʾ��Ҫ������ֵ
	boolean valueSet = false;

	// ��������		���䣺Ҳ��ͬ������ʵ���߳�ͬ��	wait()	notify()�����߳�ͨ�ţ���ο�pv�����������wait������p�����е��������̣��ź����Ŀ�����ȻҪ�����Լ������壬������ο����������valueSet�����ź�����
	synchronized void put(int n) {
		// ���û��ֵ���ȴ��߳�ȡֵ
		if (valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.n = n;
		// ��valueSet����Ϊtrue����ʾֵ�ѷ���
		valueSet = true;
		System.out.println(Thread.currentThread().getName() + "-����:" + n);
		// ֪ͨ�ȴ��̣߳�����ȡֵ����
		notify();
	}

	// ���ѷ���		���䣺ͬ������ ʵ���߳�ͬ����
	synchronized void get() {
		// ���û��ֵ���ȴ���ֵ����
		if (!valueSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + "-����:" + n);
		// ��valueSet����Ϊfalse����ʾֵ��ȡ
		valueSet = false;
		// ֪ͨ�ȴ��̣߳�������ֵ
		notify();
	}
}

// ������		���䣺�߳���
class Producer implements Runnable {
	Product product;

	Producer(Product product) {
		this.product = product;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int k = 0;
		// ����10��
		for (int i = 0; i < 10; i++) {
			product.put(k++);
		}
	}
}

// ������		���䣺�߳���
class Consumer implements Runnable {
	Product product;

	Consumer(Product product) {
		this.product = product;
		//���䣺ע������ֱ���������߳�
		new Thread(this, "Consumer").start();
	}

	public void run() {
		// ����10��
		for (int i = 0; i < 10; i++) {
			product.get();
		}
	}
}

public class WaitNotifyDemo {
	public static void main(String args[]) {
		// ʵ����һ����Ʒ���������ߺ������߹����ʵ��
		Product product = new Product();
		// ָ�������߳�
		Producer producer = new Producer(product);
		// ָ�������߳�
		Consumer consumer = new Consumer(product);
	}
}
