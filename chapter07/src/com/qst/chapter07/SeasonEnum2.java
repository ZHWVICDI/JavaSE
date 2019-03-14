package com.qst.chapter07;
//补充：包含属性和方法的枚举类
//带构造方法的枚举类
public enum SeasonEnum2 {
	// 在第一行列出4个枚举实例:春、夏、秋、冬			//补充：这里同创建普通类调用构造方法时类似。
	SPRING("春"), SUMMER("夏"), FALL("秋"), WINTER("冬");
	// 定义一个属性
	private String name;

	// 构造方法		//用于给实例name属性赋值。
	SeasonEnum2(String name) {
		this.name = name;
	}

	// 方法
	public String toString() {
		return this.name;
	}
}
