package com.qst.chapter01;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
//1.6.2
//�����л�
public class ObjectInputStreamDemo {

	public static void main(String[] args) {

		// ����һ��ObjectInputStream����������
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\PersonObject.txt"))) {
			// ��ObjectInputStream�����������ж�ȡһ�����󣬲�ǿ��ת����Person����
			Person person =(Person)ois.readObject();	
			System.out.println("�����л���ϣ������Ķ�����Ϣ���£�");
			System.out.println(person);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
