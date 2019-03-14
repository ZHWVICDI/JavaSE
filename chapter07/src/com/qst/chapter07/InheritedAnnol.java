package com.qst.chapter07;
//补充：带有元注解的注解


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//补充：指定该注解修饰范围是类、接口、注解、枚举类型。
@Target(ElementType.TYPE)
//补充：指定该注解持续时间为运行时jvm可以获取信息，为最长的注解保留期
@Retention(RetentionPolicy.RUNTIME)
//补充：指定该注解具有继承性，即父类的注解能被子类继承。
@Inherited
//定义一个注解
public @interface InheritedAnnol {
	//补充：定义两个注解成员，（注解成员由未实现的方法组成。）
	String comment();
	//补充：为该注解成员指定默认值。
	int order() default 1;
}
