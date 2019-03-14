package com.qst.chapter07;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
//Method��Ļ�ȡ���䷽��
public class MethodDemo {
	public static void main(String[] args) {
		try {
			// ��ȡString�����
			Class clazz = Class.forName("java.lang.String");
			// �������з���
			Method[] mtds = clazz.getMethods();
			// �������췽��
			for (Method m : mtds) {
				// ��ȡ���������η�
				int mod = m.getModifiers();
				// ʹ��Modifier������ķ��������ʵ�����η�,�����
				System.out.print(Modifier.toString(mod));

				// ��ȡ�����ķ�������,�����
				Class retType = m.getReturnType();
				System.out.print(" " + retType.getName());

				// ��ȡ����������,�����
				System.out.print(" " + m.getName() + "(");

				// ��ȡ�����Ĳ�������
				Class[] paramTypes = m.getParameterTypes();
				// ѭ����������Ĳ�������
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
