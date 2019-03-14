package com.qst.chapter02.util;

import java.io.FileInputStream;
import java.util.Properties;

//配置类
public class Config {
	private static Properties p = null;
	static {
		try {
			//补充：创建一个Properties p对象。
			p = new Properties();
			// 加载配置文件	补充：p.load(FileInputStream fis{这里以相对路径来创建fis流})方法	作用：加载配置文件。
			p.load(new FileInputStream("config/mysql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 获取键对应的值
	public static String getValue(String key) {
		//补充：p.get(key) 方法： 作用：获取对应键的值。返回值，Object。所以这里请转型。
		return p.get(key).toString();
	}
}
