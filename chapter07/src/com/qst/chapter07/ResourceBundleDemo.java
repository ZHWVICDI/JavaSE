package com.qst.chapter07;

import java.util.Locale;
import java.util.ResourceBundle;

//补充：ResourceBundle类使用：用于加载国家和资源包。	
//补充：资源文件内容格式：键值对
//补充：资源文件命名格式：3种。
//补充：资源文件请放在工程项目的src根目录下

//国际化资源绑定测试 
public class ResourceBundleDemo {

	public static void main(String[] args) {
		// 读取默认资源文件，跟Local默认值有关
		ResourceBundle resb1 = ResourceBundle.getBundle("myres",
				Locale.getDefault());
		System.out.println(resb1.getString("title"));
		System.out.println(resb1.getString("name"));
		System.out.println("-----------------------------");

		Locale localeEn = new Locale("en", "US");
		// 英语资源文件myres_en_US.properties
		ResourceBundle resb2 = ResourceBundle.getBundle("myres", localeEn);
		System.out.println(resb2.getString("title"));
		System.out.println(resb2.getString("name"));
		System.out.println("-----------------------------");

		// 中文资源文件myres_zh_CN.properties
		Locale localeZh = new Locale("zh", "CN");
		ResourceBundle resb3 = ResourceBundle.getBundle("myres", localeZh);
		System.out.println(resb1.getString("title"));
		System.out.println(resb1.getString("name"));
		System.out.println("-----------------------------");
	}

}
