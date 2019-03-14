package com.qst.chapter07;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
//���䣺Parameter��Ļ�ȡ���䷽��
//���䣺����Ĭ����.class�ļ��������������β�����Ϣ
//��Ҫ�ĵ�����Ϣ��������Ҫʹ��javac -parameters -d MethodParameterDemo.java������������ɰ��������β���Ϣ��class�ļ���
class MyClass {
	public void setName(String name) {
	}

	public void display(String str, List<String> list) {
	}
}

public class MethodParameterDemo {
	public static void main(String[] args) throws Exception {
		// ��ȡMyClass�������
		Class<MyClass> clazz = MyClass.class;
		// ��ȡMyClass�������public����
		Method[] mtds = clazz.getMethods();
		for (Method m : mtds) {
			// ���������
			System.out.println("��������" + m.getName());
			// ����÷�����������
			System.out.println("����������" + m.getParameterCount());
			// ��ȡ�÷������в���			//���䣺Parameter����Ļ�ȡ��������������Ϣ��
			Parameter[] parameters = m.getParameters();
			int index = 1;
			// �������в����������������Ϣ
			for (Parameter p : parameters) {
				//���䣺p.isNamePresent()	���ܣ��ж�.class�ļ��Ƿ�����ļ����β�����Ϣ	����ֵ��boolean 
				if (p.isNamePresent()) {
					System.out.println("---��" + index++ + "��������Ϣ---");
					System.out.println("��������" + p.getName());
					System.out.println("�β����ͣ�" + p.getType());
					System.out.println("�������ͣ�" + p.getParameterizedType());
				}
			}
			System.out
					.println("----------------------------------------------");

		}
	}
}
