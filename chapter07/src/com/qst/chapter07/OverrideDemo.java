package com.qst.chapter07;

class Father {
	public void info() {
		System.out.println("����info()����");
	}
}

class Child extends Father {
	// ʹ��@Overrideָ�����淽��������д���෽��
	@Override
	public void info() {
		System.out.println("������д����info()����");
	}
}

public class OverrideDemo {

	public static void main(String[] args) {

		Father obj = new Child();
		obj.info();
	}

}
