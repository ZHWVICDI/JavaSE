package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;

public class BatchDemo {
//�������£����ڶ�һ��sql���ͬʱ�ύ��
	public static void main(String[] args) {
		// ����DBUtil����
		DBUtil db = new DBUtil();
		Connection conn = null;

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

			// ͬʱ�ռ�����SQL���		���䣺stmt.addBath(sql)	���ã���sql�����ӵ��������С�
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(13,'user13','123456',0)");
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(14,'user14','123456',0)");
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(15,'user15','123456',0)");

			// ͬʱִ������SQL���		���䣺stmt.executeBatch()	���ã�ִ��������ӵ�sql��䡣
			stmt.executeBatch();

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
