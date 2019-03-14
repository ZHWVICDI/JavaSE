package com.qst.chapter07;

import java.text.NumberFormat;
import java.util.Locale;
//补充：使用NunberFormat类 进行货币格式化。
//补充：货币格式化就是在钱数前面加上￥或$的货币符号，来区分货币类型。
public class CurrencyFormatDemo {

	public static void main(String[] args) {
		// 需要格式化的数据
		double value = 987654.321;
		// 设定Locale
		Locale cnLocale = new Locale("zh", "CN");
		Locale usLocale = new Locale("en", "US");
		// 得到local对应的NumberFormat对象
		NumberFormat cnNf = NumberFormat.getCurrencyInstance(cnLocale);
		NumberFormat usNf = NumberFormat.getCurrencyInstance(usLocale);
		// 将上边的double数据格式化输出
		System.out.println("China Currency Format:" + cnNf.format(value));
		System.out.println("United Currency Format:" + usNf.format(value));
	}

}
