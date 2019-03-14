package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Ԥ����sql��䡣ִ���ٶȱ�statement����졣������Ҫ���ִ��ͬһ��sql���ʱ�����á�
public class PreparedStatementDemo {
	
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
		String user = "root";
		String pass = "toor";
		try {
			// ����oracle����
			Class.forName(driver);
			// �������ݿ�����
			Connection conn = DriverManager.getConnection(
					url, user, pass);
			// �����������sql���
			String insertSql = "INSERT INTO userdetails(id,username,password,sex) VALUES(?,?,?,?)";
			// ����PreparedStatement����
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			// ʹ��setXXX()�����Բ�����ֵ
			pstmt.setInt(1, 7);
			pstmt.setString(2, "Tom");
			pstmt.setString(3, "123456");
			pstmt.setByte(4, (byte) 1);
			// ִ�� 			���䣺�����ִ�в�ͬ��֮ǰstatement�����ִ�С�
			int result = pstmt.executeUpdate();
			
			System.out.println("����" + result + "�У�");
			// �ر�����
			pstmt.close();
			// �ر�����
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
