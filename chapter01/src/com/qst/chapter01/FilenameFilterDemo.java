package com.qst.chapter01;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {
/*FilenameFilter接口的使用：定义一个类实现接口的accept()方法,或者直接使用一个匿名类来实现。
 * 
 * */
	public static void main(String[] args) {
		// 根据路径名称创建File对象
		File file = new File("E:\\Program Files\\Java\\jre1.8.0_181");
		// 得到文件名列表
		if (file.exists() && file.isDirectory()) {
			// 显示该目录下所有文件列表
			String[] allFileNames = file.list();
			
			for (String name : allFileNames) {
				System.out.println(name);
			}
			System.out.println("--------------------");

			// 创建FileNameFilter类型的匿名类，并作为参数传入到list()方法中;补充：java编译器会自动生成一个类来实现接口
			String[] filterFileNames = file.list(new FilenameFilter() {
				//重写FilenameFilter提供的accept(File dir,String name)方法来实现该接口:File参数：目录，name参数：文件名
				public boolean accept(File dir, String name) {
					// 对文件名进行过滤，文件名的后缀为.zip或.txt
					return (name.endsWith(".zip") || name.endsWith(".txt"));
				}
			});
			System.out.println("过滤后的文件列表：");
			for (String name : filterFileNames) {
				System.out.println(name);
			}
		}

	}

}
