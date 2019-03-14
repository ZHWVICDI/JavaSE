package com.qst.chapter07;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
//补充：Parameter类的获取及其方法
//补充：这里默认是.class文件不包含方法的形参名信息
//想要的到该信息，我们需要使用javac -parameters -d MethodParameterDemo.java的命令来编译成包含方法形参信息的class文件。
class MyClass {
	public void setName(String name) {
	}

	public void display(String str, List<String> list) {
	}
}

public class MethodParameterDemo {
	public static void main(String[] args) throws Exception {
		// 获取MyClass的类对象
		Class<MyClass> clazz = MyClass.class;
		// 获取MyClass类的所有public方法
		Method[] mtds = clazz.getMethods();
		for (Method m : mtds) {
			// 输出方法名
			System.out.println("方法名：" + m.getName());
			// 输出该方法参数个数
			System.out.println("参数个数：" + m.getParameterCount());
			// 获取该方法所有参数			//补充：Parameter对象的获取，包含参数的信息。
			Parameter[] parameters = m.getParameters();
			int index = 1;
			// 遍历所有参数，并输出参数信息
			for (Parameter p : parameters) {
				//补充：p.isNamePresent()	功能：判断.class文件是否包含文件的形参名信息	返回值：boolean 
				if (p.isNamePresent()) {
					System.out.println("---第" + index++ + "个参数信息---");
					System.out.println("参数名：" + p.getName());
					System.out.println("形参类型：" + p.getType());
					System.out.println("泛型类型：" + p.getParameterizedType());
				}
			}
			System.out
					.println("----------------------------------------------");

		}
	}
}
