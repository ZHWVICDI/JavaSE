package com.qst.chapter07;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
//Feild类的获取及其方法
class Person {
	private String name;
	private int age;
	private String address;

	public String toString() {
		return "[name:" + name + " , age:" + age + " , address:" + address
				+ " ]";
	}
}

public class FieldDemo {

	public static void main(String[] args) {
		try {
			// 获取Person类对应的Class对象
			Class<Person> personClazz = Person.class;
			System.out.println("--------Person类的属性--------");
			// 返回声明的所有属性包括私有的和受保护的，但不包括超类属性			//补充：这里如果使用getFields方法则是包括超类属性。
			Field[] fields = personClazz.getDeclaredFields();
			for (Field f : fields) {
				// 获取属性的修饰符
				int mod = f.getModifiers();
				// 使用Modifier工具类的方法获得真实的修饰符,并输出
				System.out.print(Modifier.toString(mod));

				// 获取属性的类型,并输出
				Class type = f.getType();
				System.out.print(" " + type.getName());

				// 获取属性的名称,并输出
				System.out.println(" " + f.getName());
			}

			// 创建一个Person对象
			Person p = new Person();

			// 使用getDeclaredField()方法表明可获取各种访问控制符的成员变量
			// 获取Person类的name属性对象				//补充：并为其设置值
			Field nameField = personClazz.getDeclaredField("name");
			// 设置通过反射访问该成员变量时取消访问权限检查
			nameField.setAccessible(true);
			// 为p对象的name属性设置值，因String是引用类型，所以直接使用set()方法
			nameField.set(p, "赵克玲");

			// 获取Person类的age属性对象				//补充：并为其设置值
			Field ageField = personClazz.getDeclaredField("age");
			// 设置通过反射访问该成员变量时取消访问权限检查
			ageField.setAccessible(true);
			// 调用setInt()方法为p对象的age属性设置值
			ageField.setInt(p, 36);

			// 获取Person类的address属性对象			//补充：并为其设置值
			Field addressField = personClazz.getDeclaredField("address");
			// 设置通过反射访问该成员变量时取消访问权限检查
			addressField.setAccessible(true);
			// 为p对象的name属性设置值，因String是引用类型，所以直接使用set()方法
			addressField.set(p, "青岛");

			// 输出对象p的信息
			System.out.println("--------Person实例--------");
			System.out.println(p);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
