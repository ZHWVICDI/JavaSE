package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreamDemo {

	public static void main(String[] args) {

		// ����һ���Ӽ��̽������ݵ�ɨ����
		Scanner scanner = new Scanner(System.in);

		// �����ļ��ֽ������
		FileOutputStream fos = null;
		try {
			// ʵ�����ļ��ֽ��������������һ����ѡ����append ���Ա�ʾ�Ƿ�������׷�ӵ��ļ�ĩβ
			fos = new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\qst.txt",true);
			System.out.println("���������ݣ�");
			String str = scanner.nextLine();
			// ������д���ļ���,str.getBytes()���ã����ַ���ת��Ϊ�ֽ����顣����ֵ��Byte[]
			//fos.write(byte[] b)���ã����ֽ����������д�뵽�ļ�������С�
			fos.write(str.getBytes());
			System.out.println("�ѱ��棡");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر��ļ������
				fos.close();
				scanner.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
