package com.qst.chapter07;
//����RepeatableԪע���ע�ⶨ��
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//���䣺���ﶨ��һ��ע�������������valueע���Ա���ڽ��ն��@RepeatableAnnolע��

//���䣺ָ����ע��ı�������Ϊ �����ڼ���Ա�Jvmͨ�������ȡ��Ϣ��
@Retention(RetentionPolicy.RUNTIME)
//���䣺ָ����ע������η�Χ���࣬�ӿڣ�ע�⣬ö���ࡣ
@Target(ElementType.TYPE)
@interface AnnolContents {// ��ע��������
	// ����value��Ա�������ó�Ա�����ɽ��ܶ��@RepeatableAnnolע��
	RepeatableAnnol[] value();
}

//���䣺����һ���ظ�ע��

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//���䣺�����ʾ��ע������ظ�ʹ��
@Repeatable(AnnolContents.class)
public @interface RepeatableAnnol {// ��ע������ظ�
	// Ϊ��ע�ⶨ��2����Ա����
	String name() default "����ʵѵ";

	int age();
}
