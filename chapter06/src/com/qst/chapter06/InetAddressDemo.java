package com.qst.chapter06;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
//补充：InetAddress类的使用及其常用的方法	注：无构造方法，需要通过该类的静态方法创建
public class InetAddressDemo {

	public static void main(String[] args) {

		try {
			// 获取本机地址信息			//补充：获取本地地址的InetAddress对象。
			InetAddress localIp = InetAddress.getLocalHost();
			//补充：通过getCannoicalHostName方法	作用：获取Ip地址的全限定域名				返回值：String	
			System.out.println("localIp.getCanonicalHostName()= "
					+ localIp.getCanonicalHostName());
			//补充：localIp.getHostAddress方法	作用：获取该InetAdress对象对应的IP地址字符串		返回值：byte[]
			System.out.println("localIp.getHostAddress()= "
					+ localIp.getHostAddress());
			//补充：localIp.getHostName方法		作用：获取该对象的主机名称						返回值：String
			System.out.println("localIp.getHostName()= "
					+ localIp.getHostName());
			System.out.println("localIp.toString()= " + localIp.toString());
			//补充：localIp.isReachable方法		作用：判断是否可以到达该地址						返回值：boolean	参数：int timeout	超过时间
			System.out.println("localIp.isReachable(5000)= "
					+ localIp.isReachable(5000));
			System.out.println("====================================");

			// 获取指定域名地址信息		//补充：根据主机获取对应的InetAddress对象	
			InetAddress baiduIp = InetAddress.getByName("www.baidu.com");
			System.out.println("baiduIp.getCanonicalHostName()= "
					+ baiduIp.getCanonicalHostName());
			System.out.println("baiduIp.getHostAddress()= "
					+ baiduIp.getHostAddress());
			System.out.println("baiduIp.getHostName()= "
					+ baiduIp.getHostName());
			System.out.println("baiduIp.toString()= " + baiduIp.toString());
			System.out.println("baiduIp.isReachable(5000)= "
					+ baiduIp.isReachable(5000));
			System.out.println("====================================");

			// 获取指定原始IP地址信息
			// InetAddress ip = InetAddress
			// .getByAddress(new byte[] { 127, 0, 0, 1 });
			InetAddress ip = InetAddress.getByName("127.0.0.1");
			System.out.println("ip.getCanonicalHostName()= "
					+ ip.getCanonicalHostName());
			System.out.println("ip.getHostAddress()= " + ip.getHostAddress());
			System.out.println("ip.getHostName()= " + ip.getHostName());
			System.out.println("ip.toString()= " + ip.toString());
			System.out.println("ip.isReachable(5000)= " + ip.isReachable(5000));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
