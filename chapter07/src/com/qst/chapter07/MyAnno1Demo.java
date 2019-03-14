package com.qst.chapter07;
//补充：EnumAnotatedElement接口的实现类，及其使用方式。
import java.lang.reflect.Method;

//使用自定义的@ MyAnno1注解修饰类
@MyAnno1(comment = "类注解")
class MyClass1 {
	@MyAnno1(comment = "不带参数的方法", order = 2)
	public void myMethod() {
	}
}

public class MyAnno1Demo {
	public static void main(String[] args) throws Exception {
		// 获取MyClass1类注解			//补充：class对象应该实现了EnumAnotatedElement接口，调用getAnotation（Class annotype(注解类的Class对象)）	作用：获取调用对象的注解，返回值：注解类
		MyAnno1 anno1 = MyClass1.class.getAnnotation(MyAnno1.class);
		// 输出类注解信息
		System.out.println("MyClass1类的注解信息为：" + anno1.comment() + "，序号"
				+ anno1.order());

		// 获取MyClass1类的myMethod()方法
		Method mth = MyClass1.class.getMethod("myMethod");
		// 获取myMethod()方法的注解	//补充：Method类同样的实现了EnumAnotatedElement接口，通过调用getAnnotation方法来获取对象，参数为所要获取的注解类。
		MyAnno1 anno2 = mth.getAnnotation(MyAnno1.class);
		// 输出方法注解的信息			//补充：注解成员值通过调用注解对象的方法来获取。
		System.out.println("myMethod()方法的注解信息为：" + anno2.comment() + "，序号"
				+ anno2.order());
	}
}
