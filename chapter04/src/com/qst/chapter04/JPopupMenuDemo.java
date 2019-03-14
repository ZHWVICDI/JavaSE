package com.qst.chapter04;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class JPopupMenuDemo extends JFrame {
	private JPanel p;
	// 声明弹出菜单
	private JPopupMenu popMenu;
	// 声明菜单选项
	private JMenuItem miUndo, miCopy, miPost, miCut;

	public JPopupMenuDemo() {
		super("JPopupMenu弹出菜单");
		p = new JPanel();
		// 创建弹出菜单对象
		popMenu = new JPopupMenu();

		// 创建菜单选项
		miUndo = new JMenuItem("Undo");
		miCopy = new JMenuItem("Copy");
		miPost = new JMenuItem("Post");
		miCut = new JMenuItem("Cut");

		// 将菜单选项添加到菜单中
		popMenu.add(miUndo);
		popMenu.addSeparator();
		popMenu.add(miCopy);
		popMenu.add(miPost);
		popMenu.add(miCut);

		// 注册鼠标监听
		p.addMouseListener(new MouseAdapter() {
			// 重写鼠标点击事件处理方法
			public void mouseClicked(MouseEvent e) {
				// 如果点击鼠标右键
				if (e.getButton() == MouseEvent.BUTTON3) {
					int x = e.getX();
					int y = e.getY();
					// 在面板鼠标所在位置显示弹出菜单
					popMenu.show(p, x, y);
				}
			}
		});

		// 将面板添加到窗体
		this.add(p);
		// 设定窗口大小
		this.setSize(400, 300);
		// 设定窗口左上角坐标
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JPopupMenuDemo();
	}
}
