package com.qst.chapter05;

//����״̬��1.һ���߳�ִ����run��call������2.�߳��׳��쳣3.����stop����ֹͣ�̡߳�
//t.join����		������һ���̵߳ȴ���һ���߳�ִ����Ϻ����ִ��ԭ�̵߳�����
//ע�⣺������������������������ִ��ĳ�����е��������̵߳�join()��������ǰ�̻߳ᱻ������ֱ������join�������߳�ִ�����Ϊֹ��
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

		//�������߳�t1
		JoinThread t1 = new JoinThread("��Join�����߳�");
		// ����t1���߳�
		t1.start();
		
		try {
			// �ȴ�t1���߳�ִ�����
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ������߳���
		System.out.println(Thread.currentThread().getName());

		// t1���߳��Ѿ�����,isAlive()Ϊfalse
		System.out.println("���߳�����״̬[isAlive: " + t1.isAlive() + "]");
		// ��ͼ�ٴ�����t1���̣߳���ʱt1���߳��Ѿ��������ٴ��������׳�IllegalThreadStateException		���䣺��Ҫ������״̬���̵߳���start������ֻ�ܶ��½�״̬���̵߳��á�
		t1.start();
	}

}
