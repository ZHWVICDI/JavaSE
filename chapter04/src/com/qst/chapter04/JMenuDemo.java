package com.qst.chapter04;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class JMenuDemo extends JFrame {
	private JPanel p;
	// 声明菜单栏
	private JMenuBar menuBar;
	// 声明菜单
	private JMenu menuFile, menuEdit, menuHelp, menuNew;
	// 声明菜单项
	private JMenuItem miSave, miExit, miCopy, miPost, miAbout, miC, miJava,
			miOther;

	public JMenuDemo() {
		super("下拉菜单");
		p = new JPanel();
		// 创建菜单栏对象
		menuBar = new JMenuBar();
		// 将菜单栏设置到窗体中
		this.setJMenuBar(menuBar);
		// 创建菜单
		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");
		menuHelp = new JMenu("Help");
		menuNew = new JMenu("New");
		// 将菜单添加到菜单栏
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		// 将新建菜单添加到文件菜单中
		menuFile.add(menuNew);
		// 在菜单中添加分隔线
		menuFile.addSeparator();
		// 创建菜单选项
		miSave = new JMenuItem("Save");
		miExit = new JMenuItem("Exit");
		miCopy = new JMenuItem("Copy");
		miPost = new JMenuItem("Post");
		miAbout = new JMenuItem("About");
		miC = new JMenuItem("Class");
		miJava = new JMenuItem("Java Project");
		miOther = new JMenuItem("Other...");
		// 将菜单项添加到菜单中
		menuFile.add(miSave);
		menuFile.add(miExit);
		menuEdit.add(miCopy);
		menuEdit.add(miPost);
		menuHelp.add(miAbout);
		menuNew.add(miC);
		menuNew.add(miJava);
		menuNew.add(miOther);

		// 将面板添加到窗体
		this.add(p);
		// 设定窗口大小
		this.setSize(400, 300);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JMenuDemo();
	}
}
