package com.qst.chapter07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
//DateTimeFormatter �ࣺ�����ȡ�����ַ�ʽ���Լ����ʹ��DateTimeFormatter���������ض����ַ���Ϊ����ʱ�����
public class DateTimeFormatterDemo {

	// ���ں�ʱ��ĸ�ʽ��
	public static void formateMethod() {
		DateTimeFormatter[] formatters = new DateTimeFormatter[] {
				// ֱ��ʹ�ó�������DateTimeFormatter��ʽ��		//���䣺��Щ��̬�����������DateTimeFormatterʵ��.
				DateTimeFormatter.ISO_LOCAL_DATE,
				DateTimeFormatter.ISO_LOCAL_TIME,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME,
				// ʹ�ñ��ػ��Ĳ�ͬ���������DateTimeFormatter��ʽ��		//���䣺FormatStyleö�����ж������ĸ�ö��ֵ��
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,
						FormatStyle.MEDIUM),
				DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
				// ����ģʽ�ַ���������DateTimeFormatter��ʽ��			//���䣺ģʽ�ַ����μ�SimpleDateFormat��
				DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss") };
		LocalDateTime date = LocalDateTime.now();
		// ����ʹ�ò�ͬ�ĸ�ʽ����LocalDateTime���и�ʽ��
		for (int i = 0; i < formatters.length; i++) {
			// �������д����������ͬ
			System.out.println(date.format(formatters[i]));
			System.out.println(formatters[i].format(date));
		}
	}

	// �����ַ�������Ϊ���ں�ʱ��		�ص�
	public static void parseMethod() {
		//1. ����һ�������ʽ������ʱ���ַ���
		String str1 = "2015==12==02 01ʱ06��09��";
		//2.������Ҫ���������ڡ�ʱ���ַ�������������õĸ�ʽ��
		DateTimeFormatter fomatter1 = DateTimeFormatter
				.ofPattern("yyyy==MM==dd HHʱmm��ss��");
		//3. ִ�н���			���䣺����ͨ��LocalDateTime�ľ�̬parse����	���ܣ�������ʱ���ַ�������Ϊ����ʱ�����(������LocalDateTimeʵ��)������1������ʱ���ַ���2��DateTimeFormatter��ʽ��������ֵ��LocalDateTime
		LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
		System.out.println(dt1); // ��� 2015-12-02T01:06:09
		// ---��������ٴν�����һ���ַ���---
		String str2 = "2015$$$ʮ����$$$02 20Сʱ";
		DateTimeFormatter fomatter2 = DateTimeFormatter
				.ofPattern("yyy$$$MMM$$$dd HHСʱ");
		LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
		System.out.println(dt2); // ��� 2015-12-02T20:00
	}

	public static void main(String[] args) {
		// ���ø�ʽ������
		formateMethod();
		// ���ý�������
		parseMethod();
	}

}
