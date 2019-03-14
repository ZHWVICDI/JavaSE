package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//1.6.2���л�
public class ObjectOutputStreamDemo {

	public static void main(String[] args) {

		// ����һ��ObjectOutputStream���������  ���䣺���췽����ObjectOutputStream(OutputStream outStream) throws IOException
		try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\PersonObject.txt"))) {
			// ����һ��Person���͵Ķ���
			Person person = new Person("����", 25, "�ൺ");
			// �Ѷ���д�뵽�ļ��в��䣺obs.writeObject(Object obj) ���ã�д��һ��obj���󵽵��õ����С�
			obs.writeObject(person);
			obs.flush();
			System.out.println("���л���ϣ�");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
