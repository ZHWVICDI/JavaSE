package com.qst.chapter02;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.qst.chapter02.db.DBUtil;
//获取结果集的结构信息。
public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		String selectSql = "SELECT id,username,password,sex FROM userdetails";
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		try {
			// 通过工具类获取数据库连接
			db.getConnection();
			System.out.println("连接成功！");
			// 执行查询
			ResultSet rs = db.executeQuery(selectSql, null);
			
			// 获取结果集元数据		补充：rs.getMetaData()	作用：获取结果集元数据。返回值：ResultSetMetaData rsmd.注意：与dmd获取方式是有区别的。
			ResultSetMetaData rsmd = rs.getMetaData();
			//补充：int rsmd.getColumnCount()	作用：返回ResultSet对象的列数。
			System.out.println("总共有：" + rsmd.getColumnCount() + "列");
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				//补充：String rsmd.getColumnName(int column（列索引号）)	作用：获取指定列的名称
				System.out.println("列" + i + ":" + rsmd.getColumnName(i) + "\t"
						//补充：int rsmd.getColumnType(int column) 作用：获取指定列的SQL类型
						+ rsmd.getColumnTypeName(i) + "("
						//补充：String rsmd.getColumnDisplaySize(int column) 	作用：指示指定列的最大标准宽度，以字符为单位。
						+ rsmd.getColumnDisplaySize(i) + ")");
			}
			// 关闭连接
			db.closeAll();
		} catch (Exception e) {
			db.closeAll();
			e.printStackTrace();
		}
	}

}
