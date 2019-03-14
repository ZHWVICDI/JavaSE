package com.qst.chapter04;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class JToolBarDemo extends JFrame {
	private JPanel p;
	// 声明工具栏
	private JToolBar toolBar;
	private JButton btnSave, btnPreview, btnDown, btnSearch, btnDelete;

	public JToolBarDemo() {
		super("JToolBar工具栏");

		p = new JPanel();

		// 创建工具栏
		toolBar = new JToolBar();
		// 将工具栏对象添加到窗体的北部（上方）
		this.add(toolBar, BorderLayout.NORTH);

		// 创建按钮对象，按钮上有文字和图片
		btnSave = new JButton("保存", new ImageIcon("images\\save.png"));
		btnPreview = new JButton("预览", new ImageIcon("images\\preview.png"));
		btnDown = new JButton("下载", new ImageIcon("images\\down.png"));
		btnSearch = new JButton("查询", new ImageIcon("images\\search.png"));
		btnDelete = new JButton("删除", new ImageIcon("images\\delete.png"));

		// 设置按钮的工具提示文本
		btnSave.setToolTipText("保存");
		btnPreview.setToolTipText("预览");
		btnDown.setToolTipText("下载");
		btnSearch.setToolTipText("查询");
		btnDelete.setToolTipText("删除");

		// 将按钮添加到工具栏中
		toolBar.add(btnSave);
		toolBar.add(btnPreview);
		toolBar.add(btnDown);
		toolBar.add(btnSearch);
		toolBar.add(btnDelete);

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
		new JToolBarDemo();
	}
}
