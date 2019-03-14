package com.qst.chapter06;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
//补充：URLDecoder类和URLEncoder类	decode：MIME字符串	解码为 	普通字符串	encode：普通字符串	编码为	MIME字符串
public class URLDecoderDemo {

	public static void main(String[] args) {
		try {
			// 将普通字符串转换成application/x-www-form-urlencoded字符串
			String urlStr = URLEncoder.encode("Java 8高级应用与开发", "GBK");
			System.out.println(urlStr);

			// 将application/x-www-form-urlencoded字符串 转换成普通字符串
			String keyWord = URLDecoder.decode(
					"Java+8%B8%DF%BC%B6%D3%A6%D3%C3%D3%EB%BF%AA%B7%A2", "GBK");
			System.out.println(keyWord);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
