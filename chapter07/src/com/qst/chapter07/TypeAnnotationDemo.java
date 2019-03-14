package com.qst.chapter07;
//���䣺����������ע�⣬����չ�˴�ͳ����ע���λ�ã����ǻ�����������λ��ʹ�ø�����ע�⡣
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

import javax.swing.JFrame;

//����һ���򵥵�����ע�⣬�����κγ�Ա����
//���䣺��ʾ����ע��
@Target(ElementType.TYPE_USE)
@interface NotNull {
}

// ������ʱʹ��@NotNull����ע��
@NotNull
public class TypeAnnotationDemo implements
		@NotNull /* implementsʱʹ������ע�� */Serializable {
	// �����β���ʹ������ע��
	public static void main(@NotNull String[] args)
			throws @NotNull /* throwsʱʹ������ע�� */FileNotFoundException {
		Object obj = "����ʵѵ";
		// ǿ������ת��ʱʹ������ע��
		String str = (@NotNull String) obj;
		// ��������ʱʹ������ע��
		Object win = new @NotNull JFrame("QST_Login");
	}

	// ������ʹ������ע��
	public void foo(List<@NotNull String> info) {
	}
}
