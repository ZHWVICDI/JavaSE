package com.qst.chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
//获取对应类的Class对象及常用方法。
public class ClassDemo {

	public static void main(String[] args) {
		System.out.println("----String的Class类对象----");
		try {
			// 1.使用Class.forName("全限定类名")方法获取String类对象
			Class strClass = Class.forName("java.lang.String");
			System.out.println(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("----Float的Class类对象----");
		// 2.使用类的class属性获取Float类对应的Class对象
		Class fClass = Float.class;
		System.out.println(fClass);

		System.out.println("----Date类的Class类对象----");
		// 3.使用实例对象的getClass()方法获取Date类对应的Class对象
		Date nowTime = new Date();
		Class dateClass = nowTime.getClass();
		//补充：获取当前项目路径
		String path = dateClass.getResource("/").getPath().substring(1);
		System.out.println(dateClass);
		System.out.println(path);

		System.out.println("----Date类的父类----");
		System.out.println(dateClass.getSuperclass());

		System.out.println("----Date类的所有构造方法（与访问权限无关）----");
		// 获取所有构造方法				//补充：Constructor[]	Class对象.getDeclaredConsturctors()
		Constructor[] ctors = dateClass.getDeclaredConstructors();
		for (Constructor c : ctors) {
			System.out.println(c);
		}

		System.out.println("----Date类的所有public方法----");
		// 获取所有public方法				//补充：Method[] Class对象.getMethods()	作用：返回对应类的所有公有方法。
		Method[] mtds = dateClass.getMethods();
		for (Method m : mtds) {
			System.out.println(m);
		}

		// 构造一个实例对象，构造类中必须提供相应的缺省构造方法实现
		try {
			Object obj = dateClass.newInstance();
			System.out.println(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
