package com.qst.chapter08;

import java.util.NoSuchElementException;
import java.util.Optional;
//Optional���ʹ�ü��䳣�÷���			//��������һ�����������Ա���һ��T��ֵ����null
public class OptionalDemo {

	public static void main(String[] args) {
		// ����Optionalʵ����Ҳ����ͨ����������ֵ�õ���		//���䣺������������T��ֵ��Optionalʵ��
		Optional<String> name = Optional.of("Sanaulla");

		// ����û��ֵ��Optionalʵ��������ֵΪ'null'			//���䣺��������nullֵ��Optionalʵ��
		Optional empty = Optional.ofNullable(null);

		// isPresent�����������Optionalʵ���Ƿ���ֵ��		//����op.isPresent()	���ã����Optionalʵ���Ƿ���ֵ	����ֵ��boolean
		if (name.isPresent()) {
			// ����get()����Optionalֵ��					//���䣺op.get()		���ã����Optional��ֵ�򷵻ء�����ֵ��T���ͷ����׳�NoSuchElementException�쳣
			System.out.println(name.get());
		}

		try {
			// ��Optionalʵ���ϵ���get()�׳�NoSuchElementException��
			System.out.println(empty.get());
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}

		// ifPresent��������Lambda����ʽ������				//���䣺
		// ���Optionalֵ��Ϊ�գ�Lambda����ʽ�ᴦ����������ִ�в�����
		name.ifPresent((value) -> {
			System.out.println("The length of the value is: " + value.length());
		});

		// �����ֵorElse�����᷵��Optionalʵ�������򷵻ش���Ĵ�����Ϣ��		//���䣺op.orElse(T other)	���ã������ֵ����Żأ����򷵻�ָ����otherֵ��
		System.out.println(empty.orElse("There is no value present!"));
		System.out.println(name.orElse("There is some value!"));

		// orElseGet��orElse���ƣ��������ڴ����Ĭ��ֵ��
		// orElseGet����Lambda����ʽ����Ĭ��ֵ��							//���䣺���ƣ������Խ���Lambda����ʽ����Ĭ��ֵ
		System.out.println(empty.orElseGet(() -> "Default Value"));
		System.out.println(name.orElseGet(() -> "Default Value"));

		// map����ͨ�������lambda����ʽ�޸�Optonalʵ��Ĭ��ֵ��
		// Lambda����ʽ����ֵ���װΪOptionalʵ����
		Optional<String> upperName = name.map((value) -> value.toUpperCase());
		System.out.println(upperName.orElse("No value found"));

		// flatMap��map��Funtion���ǳ����ƣ���������Lambda����ʽ�ķ���ֵ��
		// map������lambda����ʽ����ֵ�������κ����ͣ����Ƿ���ֵ���װ��Optionalʵ����
		// ����flatMap������lambda����ֵ����Optional���͡�
		upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
		System.out.println(upperName.orElse("No value found"));

		// filter�������Optionaֵ�Ƿ��������������
		// ������㷵��Optionalʵ��ֵ�����򷵻ؿ�Optional��
		Optional<String> longName = name.filter((value) -> value.length() > 6);
		System.out.println(longName
				.orElse("The name is less than 6 characters"));

		// ��һ��ʾ����Optionalֵ���������������
		Optional<String> anotherName = Optional.of("Sana");
		Optional<String> shortName = anotherName.filter((value) -> value
				.length() > 6);
		System.out.println(shortName
				.orElse("The name is less than 6 characters"));

	}

}