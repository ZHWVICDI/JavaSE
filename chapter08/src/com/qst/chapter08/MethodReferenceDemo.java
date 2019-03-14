package com.qst.chapter08;
//Lambda表达式和::方法引用的最终目的		是当一个类中或者接口中的某个方法，其入口参数为一个接口类型时，使用这两种手段可以快速而简便的实现这个接口，而不必使用传统手段繁琐。
public class MethodReferenceDemo {

	public static void main(String[] args) {
		// Lambda表达式方式实现函数式接口中的抽象方法		
		FIConverter<String, Integer> converter1 = (from) -> Integer
				.valueOf(from);
		Integer a = converter1.convert("123");
		System.out.println(a);

		// ::方法引用的方式		//补充：这里直接引用了Integer的valueOf方法。实现了原接口的convert方法的方法体。
		FIConverter<String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("456");
		System.out.println(b);

		System.out.println(a + b);
	}

}
