package com.qst.chapter07;

import java.text.SimpleDateFormat;
import java.util.Date;
//���䣺SimpleDateFormat��		һ�����������ڸ�ʽ��	
//���䣺��Ҫ�˽�����ģʽ�ַ������壺D-һ���еĵڼ���	d-һ���еĵڼ���	E-�����еĵڼ���	y-��	 H-Сʱ��0-23��	h-Сʱ��0-11����ʹ��AM/PM���������磩	M-�·�	m-����	S-����	s-��	
public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		Date now = new Date();
		//���䣺����һ��SimpleDateFormat����		�ù��췽����Ҫ����һ������ģʽ�ַ�����
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(now));
		SimpleDateFormat sdf2 = 
		new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		System.out.println(sdf2.format(now));
		SimpleDateFormat sdf3 = 
		new SimpleDateFormat("������ yyyy�� MM �� dd �գ��ǽ���ĵ� D ��");
		System.out.println(sdf3.format(now));
	}

}
