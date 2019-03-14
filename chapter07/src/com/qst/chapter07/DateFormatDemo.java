package com.qst.chapter07;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
//���䣺ʹ��DateFormat���������ڸ�ʽ��	
//Ϊʲô����Ϊÿ���������ڸ�ʽ�ǲ�ͬ�ġ�����Ҳ��Ҫ���ݲ�ͬ��Locale����ʽ�����ڡ�
//���裺1.������Ӧ�ĸ�ʽ����2.ʹ�ø�ʽ������ʽ�����ݡ�
public class DateFormatDemo {

	public static void print(Date date, Locale locale) {
		// �õ���ӦLocale��������ڸ�ʽ������
		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, locale);
		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
				DateFormat.DEFAULT, locale);
		DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.SHORT, locale);
		// ��ʽ���������
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		System.out.println(df4.format(date));
	}

	public static void main(String[] args) {
		//���䣺����һ��Date���� ��ʾ���ڵ�ʱ�䡣
		Date now = new Date();
		Locale cnLocale = new Locale("zh", "CN");
		Locale usLocale = new Locale("en", "US");
		System.out.println("���ĸ�ʽ��");
		print(now, cnLocale);
		System.out.println("Ӣ�ĸ�ʽ��");
		print(now, usLocale);
	}

}
