package com.qst.chapter07;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	static void foo() {
		System.out.println("foo类方法");
	}

	default void bar() {
		System.out.println("bar默认方法");
	}

	void test(); // 只定义一个抽象方法

   // void abc(); // ① 此时再增加一个抽象方法则出错
}