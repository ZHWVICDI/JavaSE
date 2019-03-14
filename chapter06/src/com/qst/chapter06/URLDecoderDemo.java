package com.qst.chapter06;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
//���䣺URLDecoder���URLEncoder��	decode��MIME�ַ���	����Ϊ 	��ͨ�ַ���	encode����ͨ�ַ���	����Ϊ	MIME�ַ���
public class URLDecoderDemo {

	public static void main(String[] args) {
		try {
			// ����ͨ�ַ���ת����application/x-www-form-urlencoded�ַ���
			String urlStr = URLEncoder.encode("Java 8�߼�Ӧ���뿪��", "GBK");
			System.out.println(urlStr);

			// ��application/x-www-form-urlencoded�ַ��� ת������ͨ�ַ���
			String keyWord = URLDecoder.decode(
					"Java+8%B8%DF%BC%B6%D3%A6%D3%C3%D3%EB%BF%AA%B7%A2", "GBK");
			System.out.println(keyWord);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
