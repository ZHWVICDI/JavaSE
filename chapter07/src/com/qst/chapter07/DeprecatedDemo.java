package com.qst.chapter07;

public class DeprecatedDemo {
	
	//����myMethod()�����ѹ�ʱ
	@Deprecated
	public void myMethod(){
		System.out.println("�÷����ѹ�ʱ");
	}

	public static void main(String[] args) {
		//����ʹ���ѹ�ʱ�ķ����ᱻ���뾯��
		new DeprecatedDemo().myMethod();
	}

}
