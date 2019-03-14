package com.qst.chapter07;

public class DeprecatedDemo {
	
	//定义myMethod()方法已过时
	@Deprecated
	public void myMethod(){
		System.out.println("该方法已过时");
	}

	public static void main(String[] args) {
		//下面使用已过时的方法会被编译警告
		new DeprecatedDemo().myMethod();
	}

}
