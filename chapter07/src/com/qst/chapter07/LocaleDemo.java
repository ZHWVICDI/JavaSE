package com.qst.chapter07;

import java.util.Locale;
//补充：Locale类的使用及其方法		//每一个实例代表一个特定的地区和国家
public class LocaleDemo {

	public static void main(String[] args) {
		// 返回Java所支持的全部国家和语言的数组
		Locale[] localeList = Locale.getAvailableLocales();
		// 遍历数组的每个元素，依次获取所支持的国家和语言
		for (int i = 0; i < localeList.length ; i++ )
		{
			// 输出出所支持的国家和语言
			System.out.println(localeList[i].getDisplayCountry()
				+ "=" + localeList[i].getCountry()+ " "
				+ localeList[i].getDisplayLanguage()
				+ "=" + localeList[i].getLanguage());
		}
		// 获取缺省Locale信息
		Locale locale = Locale.getDefault();
		// 语言代码
		System.out.println("Language        : " + locale.getLanguage());
		// 国家代码
		System.out.println("Country         : " + locale.getCountry());
		// 语言显示名称
		System.out.println("DisplayLanguage : " + locale.getDisplayLanguage());
		// 国家显示名称
		System.out.println("DisplayCountry  : " + locale.getDisplayCountry());
		System.out.println("locale : " + locale);
		//补充：1.创建一个Locale实例表示美国的
		Locale newLocale = new Locale("en", "US");
		// 重设缺省Locale信息·	//补充:2.重设缺省信息
		Locale.setDefault(newLocale);
		//补充：3.获取Locale信息
		locale = Locale.getDefault();
		System.out.println("Language        : " + locale.getLanguage());
		System.out.println("Country         : " + locale.getCountry());
		System.out.println("DisplayLanguage : " + locale.getDisplayLanguage());
		System.out.println("DisplayCountry  : " + locale.getDisplayCountry());
		System.out.println("locale : " + locale);
	}

}
