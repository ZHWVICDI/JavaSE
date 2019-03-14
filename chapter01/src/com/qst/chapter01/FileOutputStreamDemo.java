package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreamDemo {

	public static void main(String[] args) {

		// 建立一个从键盘接收数据的扫描器
		Scanner scanner = new Scanner(System.in);

		// 声明文件字节输出流
		FileOutputStream fos = null;
		try {
			// 实例化文件字节输出流。这里有一个可选参数append 可以表示是否将新数据追加到文件末尾
			fos = new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\qst.txt",true);
			System.out.println("请输入内容：");
			String str = scanner.nextLine();
			// 将数据写入文件中,str.getBytes()作用：将字符串转换为字节数组。返回值：Byte[]
			//fos.write(byte[] b)作用：将字节数组的数据写入到文件输出流中。
			fos.write(str.getBytes());
			System.out.println("已保存！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件输出流
				fos.close();
				scanner.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
