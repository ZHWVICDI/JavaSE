package com.qst.chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
//���䣺Socket���ʹ�úͳ��÷���
public class ClientSocketDemo {

	public static void main(String[] args) {
		try {
			//�������ӵ��������˿�Ϊ28888��Socket����
			Socket socket = new Socket("127.0.0.1", 28888);
			// ��Socket��Ӧ���������װ��PrintStream
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// ��������������Ϣ
			ps.println("�����Կ���");
			ps.flush();

			// ��Socket��Ӧ����������װ��BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// �����������ص���Ϣ����ʾ
			String line = br.readLine();
			System.out.println("���Է����������ݣ�" + line);

			// �ر�
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
