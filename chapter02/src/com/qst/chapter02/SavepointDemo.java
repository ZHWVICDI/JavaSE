package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;

public class SavepointDemo {
//保存点：作用，更好的控制事务回滚。类似游戏存档点。
	public static void main(String[] args) {

		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		Connection conn = null;
		// 声明保存点对象
		Savepoint s1 = null;

		try {
			conn = db.getConnection();
			// 获取事务自动提交状态
			boolean autoCommit = conn.getAutoCommit();
			System.out.println("事务自动提交状态：" + autoCommit);
			if (autoCommit) {
				// 关闭自动提交,开启事务
				conn.setAutoCommit(false);
			}

			// 创建Statement对象
			Statement stmt = conn.createStatement();

			// 多条DML批处理语句
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(12,'user12','123456',0)");

			// 设置保存点 	补充：Savepoint	conn.setSavePoint() 作用：设置一个保存点，可以设置多个保存点。
			s1 = conn.setSavepoint();

			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(13,'user13','123456',0)");
			stmt.executeUpdate("INSERT INTO userdetails(id,username,password,sex) VALUES(14,'user14','123456',0)");

			// 回滚保存点		补充：这里只是演示，不管上面事务如何，这里都会回滚到保存点。数据库中应该会有id为12的记录。
			if (true) {
				conn.rollback(s1);
			}

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
