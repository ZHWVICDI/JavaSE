package com.qst.chapter01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriterDemo {

	public static void main(String[] args) {

		// 建立一个从键盘接收数据的扫描器
		Scanner scanner = new Scanner(System.in);

		// 声明文件字符输出流
		FileWriter fw = null;
		try {
			// 实例化文件字符输出流补充：没有会自动创建文件
			fw = new FileWriter("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\mytest2.txt");
			System.out.println("请输入内容：");
			String str = scanner.nextLine();
			// 将数据写入文件中补充：fw.write(String str) 作用：写入一个字符串，返回值：void
			fw.write(str);
			System.out.println("已保存！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件字符输出流
				fw.close();
				scanner.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
