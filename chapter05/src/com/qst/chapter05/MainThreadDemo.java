package com.qst.chapter05;
//���̣߳�ÿ�����̶����ٰ���һ�����̣߳���main������ִ�еľ������߳�ִ�е�����

public class MainThreadDemo {
	// main()����
	public static void main(String args[]) {
		// ����Thread���currentThread()������ȡ��ǰ�߳�		���䣺Thread Thread.currentThread()	���ã���ȡ���̡߳�
		Thread t = Thread.currentThread();
		// �����߳���										�������t.setName(String name)	���ã������߳����ơ�
		t.setName("MyMainThread");
		// ����߳���Ϣ
		System.out.println("���߳���: " + t);
		// ��ȡ�߳�Id	
		System.out.println("�߳�ID��" + t.getId());
		// ��ȡ�߳���
		System.out.println("�߳�����" + t.getName());
	}
}
