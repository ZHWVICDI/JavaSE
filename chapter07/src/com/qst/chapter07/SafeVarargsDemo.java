package com.qst.chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SafeVarargsDemo {
	@SafeVarargs
	public static void faultyMethod(List<String>... listStrArray) {
		// Java���Բ��������������飬���listArrayֻ�ܱ�����List[]����
		// ��ʱ�൱�ڰ�List<String>������List���Ѿ������ˡ�������
		List[] listArray = listStrArray;;// �� ����������Ⱦ��
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		// ��listArray�ĵ�һ��Ԫ�ظ�ΪmyList
		listArray[0] = myList;
		String s = listStrArray[0].get(0);
	}

	public static void main(String[] args) {
		// List list =new ArrayList();//ʹ��û�з������Ƶļ���
		// list.add(10);//δ����������ת����unchecked����
		// List<String> ls=list;// �� ����������Ⱦ��
		// System.out.println(ls.get(0));//����ClassCastException�쳣
		faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
	}

}
