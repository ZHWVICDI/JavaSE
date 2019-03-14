package com.qst.chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SafeVarargsDemo {
	@SafeVarargs
	public static void faultyMethod(List<String>... listStrArray) {
		// Java语言不允许创建泛型数组，因此listArray只能被当成List[]处理
		// 此时相当于把List<String>赋给了List，已经发生了“擦除”
		List[] listArray = listStrArray;;// ① 发生“堆污染”
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		// 把listArray的第一个元素赋为myList
		listArray[0] = myList;
		String s = listStrArray[0].get(0);
	}

	public static void main(String[] args) {
		// List list =new ArrayList();//使用没有泛型限制的集合
		// list.add(10);//未经检查的类型转换，unchecked警告
		// List<String> ls=list;// ① 发生“堆污染”
		// System.out.println(ls.get(0));//产生ClassCastException异常
		faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
	}

}
