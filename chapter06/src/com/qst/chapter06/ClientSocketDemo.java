package com.qst.chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
//补充：Socket类的使用和常用方法
public class ClientSocketDemo {

	public static void main(String[] args) {
		try {
			//创建连接到本机、端口为28888的Socket对象
			Socket socket = new Socket("127.0.0.1", 28888);
			// 将Socket对应的输出流包装成PrintStream
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// 往服务器发送信息
			ps.println("我是赵克玲");
			ps.flush();

			// 将Socket对应的输入流包装成BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// 读服务器返回的信息并显示
			String line = br.readLine();
			System.out.println("来自服务器的数据：" + line);

			// 关闭
			br.close();
			ps.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
