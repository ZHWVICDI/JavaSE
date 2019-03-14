package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteUpdateDemo {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
	private String user = "root";
	private String pass = "toor";

	public void createTable(String sql) throws Exception {
		// 加载驱动
		Class.forName(driver);
		try (
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, pass);
				// 使用Connection来创建一个Statment对象
				Statement stmt = conn.createStatement()) {
			// 执行DDL,创建数据表
			stmt.executeUpdate(sql);
		}
	}

	public long insertData(String sql) throws Exception {
		// 加载驱动
		Class.forName(driver);
		try (
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, pass);
				// 使用Connection来创建一个Statment对象
				Statement stmt = conn.createStatement()) {
			// 执行DML,返回受影响的记录条数 补充：stmt.executeUpdate() 作用：执行DDL或DML语句。返回值：受影响的记录的条数。
			return stmt.executeUpdate(sql);
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteUpdateDemo elud = new ExecuteUpdateDemo();
		elud.createTable("create table my_test1"
				+ "(test_id int primary key, " + "test_name varchar(255))");
		System.out.println("-----建表成功-----");
		
		long result = elud.insertData("insert into my_test1(test_id,test_name) "
				+ "select id,username from userdetails");
		System.out.println("--系统中共有" + result + "条记录受影响--");
	}
}