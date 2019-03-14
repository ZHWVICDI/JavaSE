package com.qst.chapter07;
//带有Repeatable元注解的注解定义
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//补充：这里定义一个注解容器，定义的value注解成员用于接收多个@RepeatableAnnol注解

//补充：指定该注解的保留策略为 运行期间可以被Jvm通过反射获取信息。
@Retention(RetentionPolicy.RUNTIME)
//补充：指定该注解的修饰范围：类，接口，注解，枚举类。
@Target(ElementType.TYPE)
@interface AnnolContents {// 该注解是容器
	// 定义value成员变量，该成员变量可接受多个@RepeatableAnnol注解
	RepeatableAnnol[] value();
}

//补充：定义一个重复注解

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//补充：这里表示该注解可以重复使用
@Repeatable(AnnolContents.class)
public @interface RepeatableAnnol {// 该注解可以重复
	// 为该注解定义2个成员变量
	String name() default "青软实训";

	int age();
}
