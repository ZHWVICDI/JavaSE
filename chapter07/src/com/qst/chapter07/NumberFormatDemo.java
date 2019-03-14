package com.qst.chapter07;

import java.text.NumberFormat;
import java.util.Locale;
//补充：使用NumberFormat类格式化数字和百分比，以及解析字符串对象为数字 		用于数字和百分比的格式化以及字符串对象的解析。
public class NumberFormatDemo {

	public static void main(String[] args) {
		// 需要格式化的数据
		double value = 987654.321;
		// 设定三个Locale		//每个实例代表一个特定的国家和地区
		Locale cnLocale = new Locale("zh", "CN");
		Locale usLocale = new Locale("en", "US");
		// 德国
		Locale deLocal3 = new Locale("de", "DE");
		
		//补充：1.获取默认的数字格式器和百分比格式器
		NumberFormat dNf = NumberFormat.getNumberInstance();
		NumberFormat pNf = NumberFormat.getPercentInstance();
		// (1.)得到三个local对应的NumberFormat对象
		NumberFormat cnNf = NumberFormat.getNumberInstance(cnLocale);
		NumberFormat usNf = NumberFormat.getNumberInstance(usLocale);
		NumberFormat deNf = NumberFormat.getNumberInstance(deLocal3);
		// 2.将上边的double数据格式化输出		//补充：调用format(double number)方法 		功能：讲该数字转换为字符串	返回值：String
		System.out.println("Default Percent Format:" + pNf.format(value));
		System.out.println("Default Number Format:" + dNf.format(value));
		System.out.println("China Number Format:" + cnNf.format(value));
		System.out.println("United Number Format:" + usNf.format(value));
		System.out.println("German Number Format:" + deNf.format(value));
		try {
			//补充(2).调用parse(String s)方法		功能：将字符串解析为Number对象	返回值：Number
			System.out.println(dNf.parse("3.14").doubleValue());
			System.out.println(dNf.parse("3.14F").doubleValue());
			// 下述语句抛出异常
			System.out.println(dNf.parse("F3.14").doubleValue());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
