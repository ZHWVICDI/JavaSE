package com.qst.chapter07;

class Father {
	public void info() {
		System.out.println("父类info()方法");
	}
}

class Child extends Father {
	// 使用@Override指定下面方法必须重写父类方法
	@Override
	public void info() {
		System.out.println("子类重写父类info()方法");
	}
}

public class OverrideDemo {

	public static void main(String[] args) {

		Father obj = new Child();
		obj.info();
	}

}
