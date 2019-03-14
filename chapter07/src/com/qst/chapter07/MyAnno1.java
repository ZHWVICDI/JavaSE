package com.qst.chapter07;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//补充：指定自定义注解@MyAnnol可以保留多长时间。 元注解
@Retention(RetentionPolicy.RUNTIME)
//补充：这里自定义注解，定义格式类似于接口的定义，在原有interface的基础上add@
public @interface MyAnno1 {
	String comment();
	//补充：为注解成员指定默认值。
	int order() default 1;
}
