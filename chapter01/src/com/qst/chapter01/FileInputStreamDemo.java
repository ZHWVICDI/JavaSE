package com.qst.chapter01;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		
		// �����ļ��ֽ�������
		FileInputStream fis = null;
		try {
			// ʵ�����ļ��ֽ�������,�����·����Ϊ������.java��һ���������ļ�
			fis = new FileInputStream(
					"src\\com\\qst\\chapter01\\FileInputStreamDemo.java");
			// ����һ������Ϊ1024���ֽ�������Ϊ������
			byte[] bbuf = new byte[1024];
			// ���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			// ʹ��ѭ���ظ����ļ��е�����
			//fis.read(byte[] b) ���ã������ݶ���byte�����С�����ֵ��ʵ�ʶ�ȡ���ֽ�������������ĩβʱ����-1
			while ((hasRead = fis.read(bbuf)) > 0) {
				// ���������е�����ת�����ַ������
				//String(byte[] b,0,hasRead)	���ã����ֽ�����ת��Ϊ�ַ���������ֵ��string
				System.out.print(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر��ļ�������
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
