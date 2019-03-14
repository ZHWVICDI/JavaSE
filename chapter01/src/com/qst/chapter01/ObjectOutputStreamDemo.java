package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//1.6.2序列化
public class ObjectOutputStreamDemo {

	public static void main(String[] args) {

		// 创建一个ObjectOutputStream对象输出流  补充：构造方法：ObjectOutputStream(OutputStream outStream) throws IOException
		try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\PersonObject.txt"))) {
			// 创建一个Person类型的对象
			Person person = new Person("张三", 25, "青岛");
			// 把对象写入到文件中补充：obs.writeObject(Object obj) 作用：写入一个obj对象到调用的流中。
			obs.writeObject(person);
			obs.flush();
			System.out.println("序列化完毕！");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
