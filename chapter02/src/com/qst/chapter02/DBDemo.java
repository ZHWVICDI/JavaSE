package com.qst.chapter02;

import java.sql.ResultSet;

import com.qst.chapter02.db.DBUtil;

public class DBDemo {

	public static void main(String[] args) {
		String selectSql = "SELECT id,username,password,sex FROM userdetails";
		String insertSql = "INSERT INTO userdetails(id,username,password,sex) VALUES(?,?,?,?)";
		String updateSql = "UPDATE userdetails SET password=? WHERE username=?";
		String deleteSql = "DELETE FROM userdetails WHERE username=?";
		// 创建DBUtil对象
		DBUtil db = new DBUtil();
		try {
			// 连接数据库
			db.getConnection();

			////////////////////////////////////////////////
			// 查询并显示原来的数据
			ResultSet rs = db.executeQuery(selectSql, null);
			System.out.println("---------原来的数据---------");
			while (rs.next()) {
				System.out.println("行 " + rs.getRow() + ":" 
						+ rs.getInt(1)+ "\t" 
						+ rs.getString(2) + "\t"
						+ rs.getString(3) + "\t"
						+ (rs.getInt(4) == 1 ? "男" : "女"));
			}
			System.out.println("-------------------------");
			
			////////////////////////////////////////////////
			// 执行添加
			int count = db.executeUpdate(insertSql, new String[] { "9", "Rose",
					"123456", "0" });
			System.out.println("添加" + count + "行！");
			
			// 执行修改
			count = db.executeUpdate(updateSql, new String[] { "686868","Tom" });
			System.out.println("修改" + count + "行！");
			
			// 执行删除
			count = db.executeUpdate(deleteSql, new String[] { "lisi" });
			System.out.println("删除" + count + "行！");
			
			////////////////////////////////////////////////
			// 查询并显示更新后的数据
			rs = db.executeQuery(selectSql, null);
			System.out.println("---------更新后的数据---------");
			while (rs.next()) {
				System.out.println("行 " + rs.getRow() + ":" 
						+ rs.getInt(1)+ "\t" 
						+ rs.getString(2) + "\t"
						+ rs.getString(3) + "\t"
						+ (rs.getInt(4) == 1 ? "男" : "女"));
			}
			System.out.println("-------------------------");
		} catch (Exception e) {
			// 关闭连接
			db.closeAll();
			e.printStackTrace();
		}
	}

}
