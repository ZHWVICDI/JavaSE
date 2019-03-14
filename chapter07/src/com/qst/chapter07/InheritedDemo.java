package com.qst.chapter07;
//补充：使用带有元注解的注解

//使用自定义的@InheritedAnnol注解修饰的Base类
@InheritedAnnol(comment = "继承注解", order = 2)
class Base {
}

// InheritedDemo类只是继承了Base类，
// 并未直接使用@InheritedAnnol注解修饰，
// 因@InheritedAnnol注解被@Inherited元注解修饰，
// 所以Base类的子类都默认被@InheritedAnnol修饰
public class InheritedDemo extends Base {
	public static void main(String[] args) {
		// 从InheritedDemo中获取InheritedAnnol注解信息		1.获取注解对象，通过调用getAnnotation方法。
		InheritedAnnol anno = InheritedDemo.class
				.getAnnotation(InheritedAnnol.class);
		// 输出InheritedAnnol注解成员信息					2.得到注解成员信息，通过调用注解类对象的方法。
		System.out.println(anno.comment() + ":" + anno.order());
		// 打印InheritedDemo类是否具有@InheritedAnnol修饰	3.Class对象（实现了EnumAnnotatedElement接口）调用isAnnotationPresent（Class annotype(注解类Class对象)） 功能：判断该类是否具有注解类修饰；返回值：boolean
		System.out.println(InheritedDemo.class
				.isAnnotationPresent(InheritedAnnol.class));
	}
}
