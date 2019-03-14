package com.qst.chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
//Consturctor��Ļ�ȡ�����Ӧ�ķ�����
public class ConstructorDemo {

	public static void main(String[] args) {
		try {
			// ��ȡString�����
			Class clazz = Class.forName("java.lang.String");
			// �������й��췽��
			Constructor[] ctors = clazz.getDeclaredConstructors();
			// �������췽��
			for (Constructor c : ctors) {
				// ��ȡ���췽�������η�
				int mod = c.getModifiers();
				// ʹ��Modifier������ķ��������ʵ�����η�,�����
				System.out.print(Modifier.toString(mod));

				// ��ȡ���췽��������,�����
				System.out.print(" " + c.getName() + "(");

				// ��ȡ���췽���Ĳ�������
				Class[] paramTypes = c.getParameterTypes();
				// ѭ��������췽���Ĳ�������
				for (int i = 0; i < paramTypes.length; i++) {
					if (i > 0) {
						System.out.print(", ");
					}
					// �����������
					System.out.print(paramTypes[i].getName());
				}
				System.out.println(");");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
