package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//预处理sql语句。执行速度比statement对象快。当我们要多次执行同一条sql语句时很适用。
public class PreparedStatementDemo {
	
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zhw?serverTimezone=GMT%2B8";
		String user = "root";
		String pass = "toor";
		try {
			// 加载oracle驱动
			Class.forName(driver);
			// 建立数据库连接
			Connection conn = DriverManager.getConnection(
					url, user, pass);
			// 定义带参数的sql语句
			String insertSql = "INSERT INTO userdetails(id,username,password,sex) VALUES(?,?,?,?)";
			// 创建PreparedStatement对象
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			// 使用setXXX()方法对参数赋值
			pstmt.setInt(1, 7);
			pstmt.setString(2, "Tom");
			pstmt.setString(3, "123456");
			pstmt.setByte(4, (byte) 1);
			// 执行 			补充：这里的执行不同于之前statement对象的执行。
			int result = pstmt.executeUpdate();
			
			System.out.println("插入" + result + "行！");
			// 关闭载体
			pstmt.close();
			// 关闭连接
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
