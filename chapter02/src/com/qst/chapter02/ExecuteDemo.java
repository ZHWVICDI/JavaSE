package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteDemo {
	/*private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String pass = "zkl123";*/
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
	private String user = "root";
	private String pass = "toor";

	public void executeSql(String sql) throws Exception {
		// ��������
		Class.forName(driver);
		try (
		// ��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(url, user, pass);
				// ʹ��Connection������һ��Statement����
				Statement stmt = conn.createStatement()) {
			// ִ��SQL,����booleanֵ��ʾ�Ƿ����ResultSet 	���䣺stmt.execute(sql) ���ã�ִ��sql��䣺����ֵ��True��ResultSet rs;false,��Ӱ���������
			boolean hasResultSet = stmt.execute(sql);
			// ���ִ�к���ResultSet�����
			if (hasResultSet) {
				try (
				// ��ȡ�����
				ResultSet rs = stmt.getResultSet()) {

					// �������ResultSet����
					while (rs.next()) {
						// ���������1�е�ֵ
						System.out.print(rs.getString(1) + "\t");
					}
					System.out.println();
				}
			} else {
				//���䣺stmt.getUpdateCount() ���ã�������sql���Ӱ��ļ�¼������ֵ��int
				System.out.println("��SQL���Ӱ��ļ�¼��" + stmt.getUpdateCount() + "��");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteDemo executeObj = new ExecuteDemo();
		System.out.println("------ִ�н����DDL���-----");
		executeObj.executeSql("create table my_test"
				+ "(test_id int primary key, " + "test_name varchar(255))");

		System.out.println("------ִ�в������ݵ�DML���-----");//��Ϊ���ݴ�userdetails����ȡ�ã����Թ���6����
		executeObj.executeSql("insert into my_test(test_id,test_name) "
				+ "select id,username from userdetails");

		System.out.println("------ִ�в�ѯ���ݵĲ�ѯ���-----");
		executeObj.executeSql("select test_name from my_test");

		System.out.println("------ִ��ɾ�����DDL���-----");
		executeObj.executeSql("drop table my_test");
	}
}
