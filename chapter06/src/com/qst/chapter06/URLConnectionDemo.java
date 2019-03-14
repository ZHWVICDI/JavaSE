package com.qst.chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//补充：URLConnection类的使用和常用方法				注：通过URL类openConnection方法来获取URLConnection对象。
public class URLConnectionDemo {

	public static void main(String[] args) {
		try {
			// 构建一URL对象
			URL mybook = new URL("http://book.moocollege.cn/java-book1.html");
			// 由URL对象获取URLConnection对象
			URLConnection urlConn = mybook.openConnection();
	        //设置请求属性，字符集是UTF-8
			urlConn.setRequestProperty("Charset", "GBK");
			
			// 由URLConnection获取输入流，并构造BufferedReader对象
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			String inputLine;
			// 循环读取并打印数据
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			// 关闭输入流
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
