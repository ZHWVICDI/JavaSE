package com.qst.chapter07;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	static void foo() {
		System.out.println("foo�෽��");
	}

	default void bar() {
		System.out.println("barĬ�Ϸ���");
	}

	void test(); // ֻ����һ�����󷽷�

   // void abc(); // �� ��ʱ������һ�����󷽷������
}