package com.qst.chapter02;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.qst.chapter02.db.DBUtil;
//��ȡ������Ľṹ��Ϣ��
public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		String selectSql = "SELECT id,username,password,sex FROM userdetails";
		// ����DBUtil����
		DBUtil db = new DBUtil();
		try {
			// ͨ���������ȡ���ݿ�����
			db.getConnection();
			System.out.println("���ӳɹ���");
			// ִ�в�ѯ
			ResultSet rs = db.executeQuery(selectSql, null);
			
			// ��ȡ�����Ԫ����		���䣺rs.getMetaData()	���ã���ȡ�����Ԫ���ݡ�����ֵ��ResultSetMetaData rsmd.ע�⣺��dmd��ȡ��ʽ��������ġ�
			ResultSetMetaData rsmd = rs.getMetaData();
			//���䣺int rsmd.getColumnCount()	���ã�����ResultSet�����������
			System.out.println("�ܹ��У�" + rsmd.getColumnCount() + "��");
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				//���䣺String rsmd.getColumnName(int column���������ţ�)	���ã���ȡָ���е�����
				System.out.println("��" + i + ":" + rsmd.getColumnName(i) + "\t"
						//���䣺int rsmd.getColumnType(int column) ���ã���ȡָ���е�SQL����
						+ rsmd.getColumnTypeName(i) + "("
						//���䣺String rsmd.getColumnDisplaySize(int column) 	���ã�ָʾָ���е�����׼��ȣ����ַ�Ϊ��λ��
						+ rsmd.getColumnDisplaySize(i) + ")");
			}
			// �ر�����
			db.closeAll();
		} catch (Exception e) {
			db.closeAll();
			e.printStackTrace();
		}
	}

}
