package com.qst.chapter07;
//补充：新增的类型注解，即扩展了传统程序注解的位置，我们还可以在以下位置使用该类型注解。
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

import javax.swing.JFrame;

//定义一个简单的类型注解，不带任何成员变量
//补充：表示类型注解
@Target(ElementType.TYPE_USE)
@interface NotNull {
}

// 定义类时使用@NotNull类型注解
@NotNull
public class TypeAnnotationDemo implements
		@NotNull /* implements时使用类型注解 */Serializable {
	// 方法形参中使用类型注解
	public static void main(@NotNull String[] args)
			throws @NotNull /* throws时使用类型注解 */FileNotFoundException {
		Object obj = "青软实训";
		// 强制类型转换时使用类型注解
		String str = (@NotNull String) obj;
		// 创建对象时使用类型注解
		Object win = new @NotNull JFrame("QST_Login");
	}

	// 泛型中使用类型注解
	public void foo(List<@NotNull String> info) {
	}
}
