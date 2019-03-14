package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;
//事务：1或多步数据库操作组成的逻辑单元，特性；ACID
//事务处理过程。如果顺利的话，我们提交事务，如果出现异常我们回滚事务。
public class TransactionDemo {
	public static void main(String args[]) throws ClassNotFoundException {
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		Connection conn = null;

		try {
			conn = db.getConnection();
			// 获取事务自动提交状态	补充： boolean conn.getAutoCommit()	作用：获取事务自动提交状态。
			boolean autoCommit = conn.getAutoCommit();
			System.out.println("事务自动提交状态：" + autoCommit);
			if (autoCommit) {
				// 关闭自动提交,开启事务
				conn.setAutoCommit(false);
			}

			// 创建Statement对象
			Statement stmt = conn.createStatement();

			// 多条DML批处理语句
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(10,'user10','123456',0)");
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(11,'user11','123456',0)");
			// 由于主键约束，下述语句将抛出异常
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(11,'user11','123456',0)");

			// 如果顺利执行则在此提交
			conn.commit();
			// 恢复原有事务提交状态
			conn.setAutoCommit(autoCommit);
			// 关闭连接
			db.closeAll();
		} catch (Exception e) {
			// 出现异常
			if (conn != null) {
				try {
					// 回滚
					conn.rollback();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
}
