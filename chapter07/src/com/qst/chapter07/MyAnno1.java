package com.qst.chapter07;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//���䣺ָ���Զ���ע��@MyAnnol���Ա����೤ʱ�䡣 Ԫע��
@Retention(RetentionPolicy.RUNTIME)
//���䣺�����Զ���ע�⣬�����ʽ�����ڽӿڵĶ��壬��ԭ��interface�Ļ�����add@
public @interface MyAnno1 {
	String comment();
	//���䣺Ϊע���Աָ��Ĭ��ֵ��
	int order() default 1;
}
