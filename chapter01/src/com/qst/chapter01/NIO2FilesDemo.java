package com.qst.chapter01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//Files类的使用
public class NIO2FilesDemo {
	public static void main(String[] args) {
		try {
			// 复制文件 									补充：Files.copy(Path p,OutpuStream ots) 作用：复制文件到指定输出流。
			Files.copy(
					Paths.get("src\\com\\qst\\chapter01\\NIO2FilesDemo.java"),
					new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\a.txt"));
			// 判断NIO2FilesDemo.java文件是否为隐藏文件		补充：Files.isHidden(Path p)作用：判断文件是否为隐藏文件。
			System.out.println("NIO2FilesDemo.java是否为隐藏文件："
					+ Files.isHidden(Paths
							.get("src/com/qst/chapter01/NIO2FilesDemo.java")));
			// 一次性读取FilesTest.java文件的所有行			补充：Files.readAllLines(Path p,Charset c) 作用：以***编码格式读取文件的所有行。返回值：List<String>
			List<String> lines = Files.readAllLines(Paths.get("src", "com",
					"qst", "chapter01", "NIO2FilesDemo.java"), Charset
					.forName("gbk"));
			System.out.println("行数：" + lines.size());
			// 判断指定文件的大小							补充:Files.size(Path p)
			System.out.println("a.txt文件的大小为：" + Files.size(Paths.get("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\a.txt")));
			List<String> poem = new ArrayList<>();
			poem.add("使用NIO.2技术");
			poem.add("往文件中写内容");
			// 直接将多个字符串内容写入指定文件中				补充：Files.write(Path p ,List<String>,Charset)	作用：以编码方式将字符串内容写入到指定文件中。
			Files.write(Paths.get("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\pome.txt"), poem, Charset.forName("gbk"));
			FileStore cStore = Files.getFileStore(Paths.get("C:"));
			// 判断C盘的总空间，可用空间		补充：先创建FileStore对象（创建方式见上面），然后调用getTotalSpace（）和getUsableSpace方法。
			System.out.println("C:共有空间：" + cStore.getTotalSpace());
			System.out.println("C:可用空间：" + cStore.getUsableSpace());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
