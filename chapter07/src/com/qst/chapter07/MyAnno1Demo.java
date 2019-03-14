package com.qst.chapter07;
//���䣺EnumAnotatedElement�ӿڵ�ʵ���࣬����ʹ�÷�ʽ��
import java.lang.reflect.Method;

//ʹ���Զ����@ MyAnno1ע��������
@MyAnno1(comment = "��ע��")
class MyClass1 {
	@MyAnno1(comment = "���������ķ���", order = 2)
	public void myMethod() {
	}
}

public class MyAnno1Demo {
	public static void main(String[] args) throws Exception {
		// ��ȡMyClass1��ע��			//���䣺class����Ӧ��ʵ����EnumAnotatedElement�ӿڣ�����getAnotation��Class annotype(ע�����Class����)��	���ã���ȡ���ö����ע�⣬����ֵ��ע����
		MyAnno1 anno1 = MyClass1.class.getAnnotation(MyAnno1.class);
		// �����ע����Ϣ
		System.out.println("MyClass1���ע����ϢΪ��" + anno1.comment() + "�����"
				+ anno1.order());

		// ��ȡMyClass1���myMethod()����
		Method mth = MyClass1.class.getMethod("myMethod");
		// ��ȡmyMethod()������ע��	//���䣺Method��ͬ����ʵ����EnumAnotatedElement�ӿڣ�ͨ������getAnnotation��������ȡ���󣬲���Ϊ��Ҫ��ȡ��ע���ࡣ
		MyAnno1 anno2 = mth.getAnnotation(MyAnno1.class);
		// �������ע�����Ϣ			//���䣺ע���Աֵͨ������ע�����ķ�������ȡ��
		System.out.println("myMethod()������ע����ϢΪ��" + anno2.comment() + "�����"
				+ anno2.order());
	}
}
