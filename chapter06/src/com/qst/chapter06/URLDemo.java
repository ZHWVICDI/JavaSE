package com.qst.chapter06;

import java.net.MalformedURLException;
import java.net.URL;
//URL���ʹ�ü��䳣�÷���
public class URLDemo {

	public static void main(String[] args) {
		try {
			//���䣺ͨ��ָ���ַ���������һ��URL����
			URL mybook = new URL("http://book.moocollege.cn/java-book1.html");
			System.out.println("Э��protocol=" + mybook.getProtocol());
			System.out.println("����host =" + mybook.getHost());
			System.out.println("�˿�port=" + mybook.getPort());
			System.out.println("�ļ�filename=" + mybook.getFile());
			System.out.println("êref=" + mybook.getRef());
			System.out.println("��ѯ��Ϣquery=" + mybook.getQuery());
			System.out.println("·��path=" + mybook.getPath());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
