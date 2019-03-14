package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
//访问数据库的5步骤
	public static void main(String[] args) {
		 //驱动程序名
        String driveName = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名test
        String databaseURL = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "toor";// 此处写自己的密码
		try {
			// 1.加载oracle驱动		补充；Class.forName(数据库驱动类)
			Class.forName(driveName);
			// 2.建立数据库连接  		补充：DriverManager.getConnection(传入数据库url连接字符串,用户名，密码)作用：建立数据连接。返回值：Connection conn
			Connection conn = DriverManager.getConnection(
					databaseURL,user , password);
			System.out.println("连接成功！");
			// 3.创建Statment对象		补充：conn.createStatement()作用：得到Statement对象.返回值：Statement stmt
			Statement stmt = conn.createStatement();
			// 4.获取查询结果集		补充：stmt.executeQuery("sql语句")作用：执行sql语句返回值：ResultSet rs
			ResultSet rs = stmt
					.executeQuery("SELECT id,username FROM userdetails");
			System.out.println("查询成功！");
			// 访问结果集中的数据		补充：rs.getXXX(索引号或“指定列名”) 作用：获取指定列的数据（当前游标所在的行）注意：索引号是从1开始，从左到右编号，列名不区分大小写。
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString("username"));
			}
			// 5.关闭结果集
			rs.close();
			//关闭载体
			stmt.close();
			//关闭连接
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
