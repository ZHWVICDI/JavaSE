package com.qst.chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//���䣺URLConnection���ʹ�úͳ��÷���				ע��ͨ��URL��openConnection��������ȡURLConnection����
public class URLConnectionDemo {

	public static void main(String[] args) {
		try {
			// ����һURL����
			URL mybook = new URL("http://book.moocollege.cn/java-book1.html");
			// ��URL�����ȡURLConnection����
			URLConnection urlConn = mybook.openConnection();
	        //�����������ԣ��ַ�����UTF-8
			urlConn.setRequestProperty("Charset", "GBK");
			
			// ��URLConnection��ȡ��������������BufferedReader����
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			String inputLine;
			// ѭ����ȡ����ӡ����
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			// �ر�������
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
