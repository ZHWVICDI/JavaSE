package com.qst.chapter07;

public class SeasonEnumDemo {
//使用枚举类，并且返回枚举类的实例值
	public static void main(String[] args) {
		System.out.println("SeasonEnum枚举类的所有实例值：");
		// 枚举类默认有一个values方法，返回该枚举类的所有实例值
		for (SeasonEnum s : SeasonEnum.values()) {
			System.out.println(s);
		}
		System.out.println("---------------------");

		// 定义一个枚举类对象,并直接赋值		//注意：定义一个枚举对象不能使用new关键字，而是使用枚举类的实例值直接赋值。
		SeasonEnum season = SeasonEnum.WINTER;
		
		// 使用switch语句判断枚举值		//注意：case表达式中的值直接使用枚举实例值得名字，前面不能使用枚举类作为限定。
		switch (season) {
		case SPRING:
			System.out.println("春暖花开，正好踏青");
			break;
		case SUMMER:
			System.out.println("夏日炎炎，适合游泳");
			break;
		case FALL:
			System.out.println("秋高气爽，进补及时");
			break;
		case WINTER:
			System.out.println("冬日雪飘，围炉赏雪");
			break;
		}

	}

}
