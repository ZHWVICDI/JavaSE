package com.qst.chapter07;
//java.lang.Enum类的使用及方法
public class EnumMethodDemo {

	public static void main(String[] args) {
		System.out.println("SeasonEnum枚举类的所有实例值以及顺序号：");
		// 输出SeasonEnum类的实例值以及顺序号
		for (SeasonEnum s : SeasonEnum.values()) {
			System.out.println(s + "--" + s.ordinal());
		}
		System.out.println("---------------------");
		// 声明4个SeasonEnum对象
		SeasonEnum s1, s2, s3, s4;
		// 赋值
		s1 = SeasonEnum.SPRING;
		s2 = SeasonEnum.SUMMER;
		s3 = SeasonEnum.FALL;
		// 调用Enum类的静态方法获取指定枚类型、指定值的枚举实例
		s4 = Enum.valueOf(SeasonEnum.class, "FALL");
		// 等价于
		// s4 = SeasonEnum.valueOf("FALL");

		// 使用compareTo()进行比较		//补充；这里比较的是序号。
		if (s1.compareTo(s2) < 0) {
			System.out.println(s1 + "在" + s2 + "之前");
		}
		// 使用equals()判断				//补充：这里比较的是值。
		if (s3.equals(s4)) {
			System.out.println(s3 + "等于" + s4);
		}
		// 使用==判断						//补充：??????
		if (s3 == s4) {
			System.out.println(s3 + "==" + s4);
		}
		System.out.println("---------------------");

		System.out.println("SeasonEnum2枚举类的所有实例值以及顺序号：");
		// 输出SeasonEnum类的实例值以及顺序号
		for (SeasonEnum2 s : SeasonEnum2.values()) {
			System.out.println(s + "--" + s.ordinal());
		}
		System.out.println("---------------------");
		// 声明4个SeasonEnum对象
		SeasonEnum2 se1, se2, se3, se4;
		// 赋值
		se1 = SeasonEnum2.SPRING;
		se2 = SeasonEnum2.SUMMER;
		se3 = SeasonEnum2.FALL;
		// 调用Enum类的静态方法获取指定枚类型、指定值的枚举实例
		se4 = Enum.valueOf(SeasonEnum2.class, "FALL");
		// 等价于
		// se4 = SeasonEnum2.valueOf("FALL");

		// 使用compareTo()进行比较
		if (se1.compareTo(se2) < 0) {
			System.out.println(se1 + "在" + se2 + "之前");
		}
		// 使用equals()判断
		if (se3.equals(se4)) {
			System.out.println(se3 + "等于" + se4);
		}
		// 使用==判断
		if (se3 == se4) {
			System.out.println(se3 + "==" + se4);
		}

	}

}
