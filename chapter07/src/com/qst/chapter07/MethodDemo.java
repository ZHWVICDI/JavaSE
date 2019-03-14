package com.qst.chapter07;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
//Method类的获取及其方法
public class MethodDemo {
	public static void main(String[] args) {
		try {
			// 获取String类对象
			Class clazz = Class.forName("java.lang.String");
			// 返回所有方法
			Method[] mtds = clazz.getMethods();
			// 遍历构造方法
			for (Method m : mtds) {
				// 获取方法的修饰符
				int mod = m.getModifiers();
				// 使用Modifier工具类的方法获得真实的修饰符,并输出
				System.out.print(Modifier.toString(mod));

				// 获取方法的返回类型,并输出
				Class retType = m.getReturnType();
				System.out.print(" " + retType.getName());

				// 获取方法的名称,并输出
				System.out.print(" " + m.getName() + "(");

				// 获取方法的参数类型
				Class[] paramTypes = m.getParameterTypes();
				// 循环输出方法的参数类型
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
