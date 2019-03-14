package com.qst.chapter07;
//���䣺ʹ���ظ�ע��
@RepeatableAnnol(age = 10)
@RepeatableAnnol(name = "�Կ���", age = 36)
public class RepeatableAnnolDemo {
	public static void main(String[] args) {
		/*
		 * ʹ��Java 8������getDeclaredAnnotationsByType()������ȡ
		 * ���θ���Ķ��@RepeatableAnnolע��
		 */
		RepeatableAnnol[] annols = RepeatableAnnolDemo.class
				.getDeclaredAnnotationsByType(RepeatableAnnol.class);
		// ����@RepeatableAnnolע�Ⲣ��ʾ
		for (RepeatableAnnol annol : annols) {
			System.out.println(annol.name() + "-->" + annol.age());
		}
		/*
		 * ʹ�ô�ͳ��getDeclaredAnnotation()������ȡ ���θ�������@AnnolContentsע��
		 */
		AnnolContents container = RepeatableAnnolDemo.class
				.getDeclaredAnnotation(AnnolContents.class);
		System.out.println(container);
	}
}
