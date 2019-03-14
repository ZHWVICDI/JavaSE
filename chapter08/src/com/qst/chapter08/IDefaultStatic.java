package com.qst.chapter08;
//java8新特性：允许接口中定义默认方法和静态方法。
public interface IDefaultStatic {
	// 抽象方法		
	double calculate(int a);

	// 默认方法			//补充：default前缀	不能通过接口访问，只能通过接口类实例来访问
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	// 静态方法			//补充：static前缀	可以通过接口名访问，也可以通过接口类实例访问
	static String msg() {
		return "接口中的静态方法";
	}

}
