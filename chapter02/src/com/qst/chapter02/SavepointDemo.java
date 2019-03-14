package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;

public class SavepointDemo {
//����㣺���ã����õĿ�������ع���������Ϸ�浵�㡣
	public static void main(String[] args) {

		// ����DBUtil����
		DBUtil db = new DBUtil();
		Connection conn = null;
		// ������������
		Savepoint s1 = null;

		try {
			conn = db.getConnection();
			// ��ȡ�����Զ��ύ״̬
			boolean autoCommit = conn.getAutoCommit();
			System.out.println("�����Զ��ύ״̬��" + autoCommit);
			if (autoCommit) {
				// �ر��Զ��ύ,��������
				conn.setAutoCommit(false);
			}

			// ����Statement����
			Statement stmt = conn.createStatement();

			// ����DML���������
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(12,'user12','123456',0)");

			// ���ñ���� 	���䣺Savepoint	conn.setSavePoint() ���ã�����һ������㣬�������ö������㡣
			s1 = conn.setSavepoint();

			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(13,'user13','123456',0)");
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(14,'user14','123456',0)");

			// �ع������		���䣺����ֻ����ʾ����������������Σ����ﶼ��ع�������㡣���ݿ���Ӧ�û���idΪ12�ļ�¼��
			if (true) {
				conn.rollback(s1);
			}

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
