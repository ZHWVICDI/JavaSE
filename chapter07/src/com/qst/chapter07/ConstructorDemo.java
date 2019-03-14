package com.qst.chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
//Consturctor类的获取及其对应的方法。
public class ConstructorDemo {

	public static void main(String[] args) {
		try {
			// 获取String类对象
			Class clazz = Class.forName("java.lang.String");
			// 返回所有构造方法
			Constructor[] ctors = clazz.getDeclaredConstructors();
			// 遍历构造方法
			for (Constructor c : ctors) {
				// 获取构造方法的修饰符
				int mod = c.getModifiers();
				// 使用Modifier工具类的方法获得真实的修饰符,并输出
				System.out.print(Modifier.toString(mod));

				// 获取构造方法的名称,并输出
				System.out.print(" " + c.getName() + "(");

				// 获取构造方法的参数类型
				Class[] paramTypes = c.getParameterTypes();
				// 循环输出构造方法的参数类型
				for (int i = 0; i < paramTypes.length; i++) {
					if (i > 0) {
						System.out.print(", ");
					}
					// 输出类型名称
					System.out.print(paramTypes[i].getName());
				}
				System.out.println(");");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
