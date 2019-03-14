package com.qst.chapter05;
//�߳��������ڵ���ʾ��
class MyThread extends Thread {
	public void run() {
		int sum=0;
		for(int i=0;i<1000;i++){
			sum+=i;
		}
		System.out.println("���߳���ͣ�"+sum);
	}
}

public class ThreadLifeDemo {

	public static void main(String[] args) throws Exception {
		MyThread thread1 = new MyThread();
		//���䣺�ж��߳��Ƿ�������״̬ 	 t.isAlive()
		System.out.println("�½�״̬[isAlive: " + thread1.isAlive() + "]");
		
		//�߳�����
		thread1.start();	
		System.out.println("����״̬[isAlive: " + thread1.isAlive() + "]");
		
		//�߳�����1000���루��1�룩	���䣺Thread.sleep(������)	ע��Ҫ����trycatch����
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߳̽���[isAlive: " + thread1.isAlive() + "]");
	}

}
