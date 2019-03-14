package com.qst.chapter01;

import java.nio.CharBuffer;
//Buffer��
public class NIOBufferDemo {

	public static void main(String[] args) {
		// ����Buffer���䣺ͨ����̬��������ȡһ��Buffer����allocate(int capacity)//�����ʾ����һ����������8���ַ�������BUffer���󣬳�ʼλ�ã�limit==capacity��position==0
		CharBuffer buff = CharBuffer.allocate(8);    // ��
		System.out.println("capacity: "	+ buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// ����Ԫ��
		buff.put('a');
		buff.put('b');
		buff.put('c');      // ��
		System.out.println("��������Ԫ�غ�position = "//����Ԫ�غ�position��λ��Ϊ3��limit��λ��Ϊcapacity������������Ѷ�д���򣬴���д���򡣣���ʵָ����д�룬���ｫ��д��Ϊд�룩
			+ buff.position());
		// ����flip()���� 	���䣺���ｫposition����Ϊ0��Ȼ��limit��λ�����õ�ԭposition��λ�á����������limit��capacity֮��������ܶ�д��������֮ǰ����Ԫ�ص�����Ϊδ��д�������ﷴת����Ǵ��������򣬲��ܶ������򣩡�
		buff.flip();	  // ��
		System.out.println("ִ��flip()��limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// ȡ����һ��Ԫ��
		System.out.println("��һ��Ԫ��(position=0)��" + buff.get());  // ��
		System.out.println("ȡ��һ��Ԫ�غ�position = "
			+ buff.position());
		// ����clear����
		buff.clear();     // �ݲ��䣺����position=0��limit=capacity��
		System.out.println("ִ��clear()��limit = " + buff.limit());
		System.out.println("ִ��clear()��position = "
			+ buff.position());
		System.out.println("ִ��clear()�󣬻��������ݲ�û�б������"
			+ "������Ԫ��Ϊ��" +  buff.get(2));    // �޲��䣺���������������ȡ���ݣ�position��ֵ���ᱻӰ�졣��������������Ӱ��position��ֵ��
		System.out.println("ִ�о��Զ�ȡ��position = "
			+ buff.position());

	}

}
