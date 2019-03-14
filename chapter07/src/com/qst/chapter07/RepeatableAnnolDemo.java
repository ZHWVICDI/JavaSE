package com.qst.chapter07;
//补充：使用重复注解
@RepeatableAnnol(age = 10)
@RepeatableAnnol(name = "赵克玲", age = 36)
public class RepeatableAnnolDemo {
	public static void main(String[] args) {
		/*
		 * 使用Java 8新增的getDeclaredAnnotationsByType()方法获取
		 * 修饰该类的多个@RepeatableAnnol注解
		 */
		RepeatableAnnol[] annols = RepeatableAnnolDemo.class
				.getDeclaredAnnotationsByType(RepeatableAnnol.class);
		// 遍历@RepeatableAnnol注解并显示
		for (RepeatableAnnol annol : annols) {
			System.out.println(annol.name() + "-->" + annol.age());
		}
		/*
		 * 使用传统的getDeclaredAnnotation()方法获取 修饰该类的类的@AnnolContents注解
		 */
		AnnolContents container = RepeatableAnnolDemo.class
				.getDeclaredAnnotation(AnnolContents.class);
		System.out.println(container);
	}
}
