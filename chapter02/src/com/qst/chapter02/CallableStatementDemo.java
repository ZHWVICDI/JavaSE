package com.qst.chapter02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementDemo {
//这里我先把数据库的存储过程了解了再回过头来看。
	public static void main(String[] args) {
		try {
			// 加载oracle驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 建立数据库连接
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "zkl123");
			System.out.println("连接成功！");
			// ///////////////////////////////////////////////////
			// 创建CallableStatement对象，调用带IN参数的存储过程
			CallableStatement cstmt = conn
					.prepareCall("{call addUserdetails(?,?,?,?)}");
			// 为IN参数赋值
			cstmt.setInt(1, 8);
			cstmt.setString(2, "linghuchong");
			cstmt.setString(3, "123456");
			cstmt.setByte(4, (byte) 1);
			// 执行查询
			cstmt.execute();
			System.out.println("成功插入记录");

			// ///////////////////////////////////////////////////
			// 调用有返回值的函数
			cstmt = conn.prepareCall("{?=call changePwd(?,?)}");
			// 注册OUT参数的类型
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			// 为IN参数赋值
			cstmt.setString(2, "linghuchong");
			cstmt.setString(3, "888888");
			// 执行
			cstmt.execute();
			// 通过参数索引获取返回值
			int r = cstmt.getInt(1);
			System.out.println("修改密码，返回值为：" + r);

			// ///////////////////////////////////////////////////
			// 调用带OUT参数的存储过程
			cstmt = conn.prepareCall("{call getUserCount(?)}");
			// 注册OUT参数的类型
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			// 执行
			cstmt.execute();
			int count = cstmt.getInt(1);
			System.out.println("总人数为:" + count);
			// ///////////////////////////////////////////////////
			// 调用带IN/OUT参数的存储过程
			cstmt = conn.prepareCall("{call addSub(?,?)}");
			// 为IN参数赋值
			cstmt.setInt(1, 8);
			cstmt.setInt(2, 6);
			// 注册OUT参数的类型
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.execute();
			// 通过参数索引获取返回值
			int sum = cstmt.getInt(1);
			int sub = cstmt.getInt(2);
			System.out.println("和:" + sum + ",差:" + sub);

			// 关闭
			cstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
