package com.qst.chapter01;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// 声明一个BufferedReader流的对象 补充：这是处理流，下面的FileReader是节点流
		BufferedReader br = null;
		try {
			// 实例化BufferedReader流，连接FileReader流用于读文件，补充：这里同样使用相对路径来创建对象
			br = new BufferedReader(new FileReader(
					"src\\com\\qst\\chapter01\\ReaderDemo.java"));
			String result = null;
			//循环读文件，一次读一行补充：br.readLine()作用：读取一行数据，返回值：读取到末尾时返回null
			while ((result = br.readLine()) != null) {
				//输出
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭缓冲流
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
