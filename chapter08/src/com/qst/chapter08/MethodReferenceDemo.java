package com.qst.chapter08;
//Lambda���ʽ��::�������õ�����Ŀ��		�ǵ�һ�����л��߽ӿ��е�ĳ������������ڲ���Ϊһ���ӿ�����ʱ��ʹ���������ֶο��Կ��ٶ�����ʵ������ӿڣ�������ʹ�ô�ͳ�ֶη�����
public class MethodReferenceDemo {

	public static void main(String[] args) {
		// Lambda���ʽ��ʽʵ�ֺ���ʽ�ӿ��еĳ��󷽷�		
		FIConverter<String, Integer> converter1 = (from) -> Integer
				.valueOf(from);
		Integer a = converter1.convert("123");
		System.out.println(a);

		// ::�������õķ�ʽ		//���䣺����ֱ��������Integer��valueOf������ʵ����ԭ�ӿڵ�convert�����ķ����塣
		FIConverter<String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("456");
		System.out.println(b);

		System.out.println(a + b);
	}

}
