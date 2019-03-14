package com.qst.chapter02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.qst.chapter02.db.DBUtil;

public class BatchDemo {
//批量更新：用于对一组sql语句同时提交。
	public static void main(String[] args) {
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		Connection conn = null;

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

			// 同时收集多条SQL语句		补充：stmt.addBath(sql)	作用：将sql语句添加到批处理中。
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(13,'user13','123456',0)");
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(14,'user14','123456',0)");
			stmt.addBatch("INSERT INTO userdetails(id,username,password,sex) VALUES(15,'user15','123456',0)");

			// 同时执行所有SQL语句		补充：stmt.executeBatch()	作用：执行所有添加的sql语句。
			stmt.executeBatch();

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
