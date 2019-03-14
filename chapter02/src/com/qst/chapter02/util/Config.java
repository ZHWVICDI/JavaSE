package com.qst.chapter02.util;

import java.io.FileInputStream;
import java.util.Properties;

//������
public class Config {
	private static Properties p = null;
	static {
		try {
			//���䣺����һ��Properties p����
			p = new Properties();
			// ���������ļ�	���䣺p.load(FileInputStream fis{���������·��������fis��})����	���ã����������ļ���
			p.load(new FileInputStream("config/mysql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ��ȡ����Ӧ��ֵ
	public static String getValue(String key) {
		//���䣺p.get(key) ������ ���ã���ȡ��Ӧ����ֵ������ֵ��Object������������ת�͡�
		return p.get(key).toString();
	}
}
