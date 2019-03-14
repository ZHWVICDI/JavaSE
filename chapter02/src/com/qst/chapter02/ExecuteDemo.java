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
		// 加载驱动
		Class.forName(driver);
		try (
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, pass);
				// 使用Connection来创建一个Statement对象
				Statement stmt = conn.createStatement()) {
			// 执行SQL,返回boolean值表示是否包含ResultSet 	补充：stmt.execute(sql) 作用：执行sql语句：返回值：True，ResultSet rs;false,受影响的行数。
			boolean hasResultSet = stmt.execute(sql);
			// 如果执行后有ResultSet结果集
			if (hasResultSet) {
				try (
				// 获取结果集
				ResultSet rs = stmt.getResultSet()) {

					// 迭代输出ResultSet对象
					while (rs.next()) {
						// 依次输出第1列的值
						System.out.print(rs.getString(1) + "\t");
					}
					System.out.println();
				}
			} else {
				//补充：stmt.getUpdateCount() 作用：返回受sql语句影响的记录。返回值：int
				System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteDemo executeObj = new ExecuteDemo();
		System.out.println("------执行建表的DDL语句-----");
		executeObj.executeSql("create table my_test"
				+ "(test_id int primary key, " + "test_name varchar(255))");

		System.out.println("------执行插入数据的DML语句-----");//因为数据从userdetails表中取得，所以共有6条。
		executeObj.executeSql("insert into my_test(test_id,test_name) "
				+ "select id,username from userdetails");

		System.out.println("------执行查询数据的查询语句-----");
		executeObj.executeSql("select test_name from my_test");

		System.out.println("------执行删除表的DDL语句-----");
		executeObj.executeSql("drop table my_test");
	}
}
