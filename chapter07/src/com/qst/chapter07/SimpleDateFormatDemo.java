package com.qst.chapter07;

import java.text.SimpleDateFormat;
import java.util.Date;
//补充：SimpleDateFormat类		一个更简便的日期格式器	
//补充：需要了解日期模式字符的意义：D-一年中的第几天	d-一月中的第几天	E-星期中的第几天	y-年	 H-小时（0-23）	h-小时（0-11，并使用AM/PM区分上下午）	M-月份	m-分钟	S-毫秒	s-秒	
public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		Date now = new Date();
		//补充：创建一个SimpleDateFormat对象		该构造方法需要传入一个日期模式字符串。
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(now));
		SimpleDateFormat sdf2 = 
		new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		System.out.println(sdf2.format(now));
		SimpleDateFormat sdf3 = 
		new SimpleDateFormat("现在是 yyyy年 MM 月 dd 日，是今年的第 D 天");
		System.out.println(sdf3.format(now));
	}

}
