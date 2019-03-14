package com.qst.chapter01;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		
		// 声明文件字节输入流
		FileInputStream fis = null;
		try {
			// 实例化文件字节输入流,以相对路径作为参数，.java是一个二进制文件
			fis = new FileInputStream(
					"src\\com\\qst\\chapter01\\FileInputStreamDemo.java");
			// 创建一个长度为1024的字节数组作为缓冲区
			byte[] bbuf = new byte[1024];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环重复读文件中的数据
			//fis.read(byte[] b) 作用：将数据读入byte数组中。返回值：实际读取的字节数。到达流的末尾时返回-1
			while ((hasRead = fis.read(bbuf)) > 0) {
				// 将缓冲区中的数据转换成字符串输出
				//String(byte[] b,0,hasRead)	作用：将字节数组转换为字符串，返回值：string
				System.out.print(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件输入流
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
