package com.qst.chapter01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriterDemo {

	public static void main(String[] args) {

		// ����һ���Ӽ��̽������ݵ�ɨ����
		Scanner scanner = new Scanner(System.in);

		// �����ļ��ַ������
		FileWriter fw = null;
		try {
			// ʵ�����ļ��ַ���������䣺û�л��Զ������ļ�
			fw = new FileWriter("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\mytest2.txt");
			System.out.println("���������ݣ�");
			String str = scanner.nextLine();
			// ������д���ļ��в��䣺fw.write(String str) ���ã�д��һ���ַ���������ֵ��void
			fw.write(str);
			System.out.println("�ѱ��棡");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر��ļ��ַ������
				fw.close();
				scanner.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
