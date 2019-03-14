package com.qst.chapter01;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// ����һ��BufferedReader���Ķ��� ���䣺���Ǵ������������FileReader�ǽڵ���
		BufferedReader br = null;
		try {
			// ʵ����BufferedReader��������FileReader�����ڶ��ļ������䣺����ͬ��ʹ�����·������������
			br = new BufferedReader(new FileReader(
					"src\\com\\qst\\chapter01\\ReaderDemo.java"));
			String result = null;
			//ѭ�����ļ���һ�ζ�һ�в��䣺br.readLine()���ã���ȡһ�����ݣ�����ֵ����ȡ��ĩβʱ����null
			while ((result = br.readLine()) != null) {
				//���
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �رջ�����
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
