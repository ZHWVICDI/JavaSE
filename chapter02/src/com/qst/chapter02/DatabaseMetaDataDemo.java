package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.qst.chapter02.db.DBUtil;

public class DatabaseMetaDataDemo {
//��ȡ��ǰ���ݿ����ӵ������Ϣ��
	public static void main(String[] args) {
		try {
			// ����DBUtil����
			DBUtil db = new DBUtil();
			// ͨ���������ȡ���ݿ�����
			Connection conn = db.getConnection();
			System.out.println("���ӳɹ���");
			
			// ����DatabaseMetaData����  	���䣺conn.getMetaData()������ ���ã�����DatabaseMetaData���� ������ֵ��DatabaseMetaData dmd.
			DatabaseMetaData dmd = conn.getMetaData();
			
			System.out.println("���ݿ��Ʒ����" + dmd.getDatabaseProductName());
			System.out.println("���ݿ�汾�ţ�" + dmd.getDatabaseProductVersion());
			System.out.println("������������" + dmd.getDriverName());
			System.out.println("���ݿ�URL��" + dmd.getURL());
			
			// �ر�����
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
