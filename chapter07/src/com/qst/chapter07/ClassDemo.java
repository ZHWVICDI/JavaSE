package com.qst.chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
//��ȡ��Ӧ���Class���󼰳��÷�����
public class ClassDemo {

	public static void main(String[] args) {
		System.out.println("----String��Class�����----");
		try {
			// 1.ʹ��Class.forName("ȫ�޶�����")������ȡString�����
			Class strClass = Class.forName("java.lang.String");
			System.out.println(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("----Float��Class�����----");
		// 2.ʹ�����class���Ի�ȡFloat���Ӧ��Class����
		Class fClass = Float.class;
		System.out.println(fClass);

		System.out.println("----Date���Class�����----");
		// 3.ʹ��ʵ�������getClass()������ȡDate���Ӧ��Class����
		Date nowTime = new Date();
		Class dateClass = nowTime.getClass();
		//���䣺��ȡ��ǰ��Ŀ·��
		String path = dateClass.getResource("/").getPath().substring(1);
		System.out.println(dateClass);
		System.out.println(path);

		System.out.println("----Date��ĸ���----");
		System.out.println(dateClass.getSuperclass());

		System.out.println("----Date������й��췽���������Ȩ���޹أ�----");
		// ��ȡ���й��췽��				//���䣺Constructor[]	Class����.getDeclaredConsturctors()
		Constructor[] ctors = dateClass.getDeclaredConstructors();
		for (Constructor c : ctors) {
			System.out.println(c);
		}

		System.out.println("----Date�������public����----");
		// ��ȡ����public����				//���䣺Method[] Class����.getMethods()	���ã����ض�Ӧ������й��з�����
		Method[] mtds = dateClass.getMethods();
		for (Method m : mtds) {
			System.out.println(m);
		}

		// ����һ��ʵ�����󣬹������б����ṩ��Ӧ��ȱʡ���췽��ʵ��
		try {
			Object obj = dateClass.newInstance();
			System.out.println(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
