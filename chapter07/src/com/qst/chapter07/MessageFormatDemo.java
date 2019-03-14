package com.qst.chapter07;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
//消息格式化	：用于动态处理消息。
public class MessageFormatDemo {

	/**
	 * 定义消息格式化方法msgFormat()
	 * 
	 * @param pattern
	 *            模式字符串
	 * @param locale
	 *            语言环境
	 * @param msgParams
	 *            占位符参数
	 */
	//补充：该静态方法用于	实现根据模式字符串，构建MessageFormat对象。然后设置语言环境，传入包含信息的对象数组。最后进行解析，转换为字符串。
	public static void msgFormat(String pattern, Locale locale,
			Object[] msgParams) {
		// 2.根据指定的pattern模式字符串构造MessageFormat对象
		MessageFormat formatter = new MessageFormat(pattern);
		// formatter.applyPattern(pattern);
		// 3.设置语言环境
		formatter.setLocale(locale);
		// 4.5.根据传递的参数，对应替换模式串中的占位符
		System.out.println(formatter.format(msgParams));
	}

	public static void main(String[] args) {
		// 1.定义一个带占位符的模式字符串
		String pattern1 = "{0},您好!欢迎您在{1}访问本系统！";
		// 获取默认语言环境
		Locale locale1 = Locale.getDefault();
		// 输出国家
		System.out.println(locale1.getCountry());
		// 构造模式串所需的对象数组
		Object[] msgParams1 = { "赵克玲", new Date() };
		// 调用msgFormat()实现消息格式化输出
		msgFormat(pattern1, locale1, msgParams1);

		// 定义一个带占位符的模式字符串,对占位符进行不同的格式化	
		String pattern2 = "{0} ,你好!欢迎您在{1,date,long}访问本系统,现在是{1,time,hh:mm:ss}";
		// 调用msgFormat()实现消息格式化输出
		msgFormat(pattern2, locale1, msgParams1);

		System.out.println("--------------------------------------");
		// 创建一个语言环境
		Locale locale2 = new Locale("en", "US");
		// 输出国家
		System.out.println(locale2.getCountry());
		// 构造模式串所需的对象数组
		Object[] msgParams2 = { "QST青软实训", new Date() };
		// 调用msgFormat()实现消息格式化输出
		msgFormat(pattern1, locale2, msgParams2);
		msgFormat(pattern2, locale2, msgParams2);
	}

}
