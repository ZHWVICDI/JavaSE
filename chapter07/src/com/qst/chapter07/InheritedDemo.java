package com.qst.chapter07;
//���䣺ʹ�ô���Ԫע���ע��

//ʹ���Զ����@InheritedAnnolע�����ε�Base��
@InheritedAnnol(comment = "�̳�ע��", order = 2)
class Base {
}

// InheritedDemo��ֻ�Ǽ̳���Base�࣬
// ��δֱ��ʹ��@InheritedAnnolע�����Σ�
// ��@InheritedAnnolע�ⱻ@InheritedԪע�����Σ�
// ����Base������඼Ĭ�ϱ�@InheritedAnnol����
public class InheritedDemo extends Base {
	public static void main(String[] args) {
		// ��InheritedDemo�л�ȡInheritedAnnolע����Ϣ		1.��ȡע�����ͨ������getAnnotation������
		InheritedAnnol anno = InheritedDemo.class
				.getAnnotation(InheritedAnnol.class);
		// ���InheritedAnnolע���Ա��Ϣ					2.�õ�ע���Ա��Ϣ��ͨ������ע�������ķ�����
		System.out.println(anno.comment() + ":" + anno.order());
		// ��ӡInheritedDemo���Ƿ����@InheritedAnnol����	3.Class����ʵ����EnumAnnotatedElement�ӿڣ�����isAnnotationPresent��Class annotype(ע����Class����)�� ���ܣ��жϸ����Ƿ����ע�������Σ�����ֵ��boolean
		System.out.println(InheritedDemo.class
				.isAnnotationPresent(InheritedAnnol.class));
	}
}
