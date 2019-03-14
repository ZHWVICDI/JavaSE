package com.qst.chapter02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.qst.chapter02.db.DBUtil;

public class DatabaseMetaDataDemo {
//获取当前数据库连接的相关信息。
	public static void main(String[] args) {
		try {
			// 创建DBUtil对象
			DBUtil db = new DBUtil();
			// 通过工具类获取数据库连接
			Connection conn = db.getConnection();
			System.out.println("连接成功！");
			
			// 创建DatabaseMetaData对象  	补充：conn.getMetaData()方法： 作用：创建DatabaseMetaData对象 。返回值：DatabaseMetaData dmd.
			DatabaseMetaData dmd = conn.getMetaData();
			
			System.out.println("数据库产品名：" + dmd.getDatabaseProductName());
			System.out.println("数据库版本号：" + dmd.getDatabaseProductVersion());
			System.out.println("驱动类型名：" + dmd.getDriverName());
			System.out.println("数据库URL：" + dmd.getURL());
			
			// 关闭连接
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
