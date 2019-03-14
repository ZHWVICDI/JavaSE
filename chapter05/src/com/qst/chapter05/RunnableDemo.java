package com.qst.chapter05;
//ͨ��ʵ��Runnable�ӿ��������̡߳�
//1. ThreadTask�ࣨ�߳������ࣩʵ��Runnable�ӿ�
class ThreadTask implements Runnable {
	// ��дrun���������񷽷�
	public void run() {
		// ��ȡ��ǰ�̵߳�����
		for (int i = 0; i < 100; i++) {
			// ʵ��Runnable�ӿ�ʱ��ֻ��ʹ��Thread.currentThread()��ȡ��ǰ�߳�
			// �ٵ���getName()�������ص�ǰ�̵߳�����
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args) {
		// 2.����һ��Thread���ʵ��,�������ThreadTask��Ķ���		���䣺Thread t=new Thread(Runnable target)	���ã�����һ��Thread���ʵ����
		Thread t = new Thread(new ThreadTask());
		// 3.����start()���������߳�
		t.start();

		// ���߳�����
		for (int i = 1000; i < 1100; i++) {
			// ʹ��Thread.currentThread().getName()��ȡ���߳�����
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

}
