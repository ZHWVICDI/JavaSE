package com.qst.chapter07;
//���䣺����Ԫע���ע��


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//���䣺ָ����ע�����η�Χ���ࡢ�ӿڡ�ע�⡢ö�����͡�
@Target(ElementType.TYPE)
//���䣺ָ����ע�����ʱ��Ϊ����ʱjvm���Ի�ȡ��Ϣ��Ϊ���ע�Ᵽ����
@Retention(RetentionPolicy.RUNTIME)
//���䣺ָ����ע����м̳��ԣ��������ע���ܱ�����̳С�
@Inherited
//����һ��ע��
public @interface InheritedAnnol {
	//���䣺��������ע���Ա����ע���Ա��δʵ�ֵķ�����ɡ���
	String comment();
	//���䣺Ϊ��ע���Աָ��Ĭ��ֵ��
	int order() default 1;
}
