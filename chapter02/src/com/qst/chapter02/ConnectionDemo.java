package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
//�������ݿ��5����
	public static void main(String[] args) {
		 //����������
        String driveName = "com.mysql.cj.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���test
        String databaseURL = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "toor";// �˴�д�Լ�������
		try {
			// 1.����oracle����		���䣻Class.forName(���ݿ�������)
			Class.forName(driveName);
			// 2.�������ݿ�����  		���䣺DriverManager.getConnection(�������ݿ�url�����ַ���,�û���������)���ã������������ӡ�����ֵ��Connection conn
			Connection conn = DriverManager.getConnection(
					databaseURL,user , password);
			System.out.println("���ӳɹ���");
			// 3.����Statment����		���䣺conn.createStatement()���ã��õ�Statement����.����ֵ��Statement stmt
			Statement stmt = conn.createStatement();
			// 4.��ȡ��ѯ�����		���䣺stmt.executeQuery("sql���")���ã�ִ��sql��䷵��ֵ��ResultSet rs
			ResultSet rs = stmt
					.executeQuery("SELECT id,username FROM userdetails");
			System.out.println("��ѯ�ɹ���");
			// ���ʽ�����е�����		���䣺rs.getXXX(�����Ż�ָ��������) ���ã���ȡָ���е����ݣ���ǰ�α����ڵ��У�ע�⣺�������Ǵ�1��ʼ�������ұ�ţ����������ִ�Сд��
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString("username"));
			}
			// 5.�رս����
			rs.close();
			//�ر�����
			stmt.close();
			//�ر�����
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
