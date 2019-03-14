package com.qst.chapter07;

import java.text.NumberFormat;
import java.util.Locale;
//���䣺ʹ��NunberFormat�� ���л��Ҹ�ʽ����
//���䣺���Ҹ�ʽ��������Ǯ��ǰ����ϣ���$�Ļ��ҷ��ţ������ֻ������͡�
public class CurrencyFormatDemo {

	public static void main(String[] args) {
		// ��Ҫ��ʽ��������
		double value = 987654.321;
		// �趨Locale
		Locale cnLocale = new Locale("zh", "CN");
		Locale usLocale = new Locale("en", "US");
		// �õ�local��Ӧ��NumberFormat����
		NumberFormat cnNf = NumberFormat.getCurrencyInstance(cnLocale);
		NumberFormat usNf = NumberFormat.getCurrencyInstance(usLocale);
		// ���ϱߵ�double���ݸ�ʽ�����
		System.out.println("China Currency Format:" + cnNf.format(value));
		System.out.println("United Currency Format:" + usNf.format(value));
	}

}
