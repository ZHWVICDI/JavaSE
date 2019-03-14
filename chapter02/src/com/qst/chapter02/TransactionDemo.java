package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;
//����1��ಽ���ݿ������ɵ��߼���Ԫ�����ԣ�ACID
//��������̡����˳���Ļ��������ύ������������쳣���ǻع�����
public class TransactionDemo {
	public static void main(String args[]) throws ClassNotFoundException {
		// ����DBUtil����
		DBUtil db = new DBUtil();
		Connection conn = null;

		try {
			conn = db.getConnection();
			// ��ȡ�����Զ��ύ״̬	���䣺 boolean conn.getAutoCommit()	���ã���ȡ�����Զ��ύ״̬��
			boolean autoCommit = conn.getAutoCommit();
			System.out.println("�����Զ��ύ״̬��" + autoCommit);
			if (autoCommit) {
				// �ر��Զ��ύ,��������
				conn.setAutoCommit(false);
			}

			// ����Statement����
			Statement stmt = conn.createStatement();

			// ����DML���������
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(10,'user10','123456',0)");
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(11,'user11','123456',0)");
			// ��������Լ����������佫�׳��쳣
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(11,'user11','123456',0)");

			// ���˳��ִ�����ڴ��ύ
			conn.commit();
			// �ָ�ԭ�������ύ״̬
			conn.setAutoCommit(autoCommit);
			// �ر�����
			db.closeAll();
		} catch (Exception e) {
			// �����쳣
			if (conn != null) {
				try {
					// �ع�
					conn.rollback();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
}
