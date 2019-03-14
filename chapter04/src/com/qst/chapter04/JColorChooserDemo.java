package com.qst.chapter04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JColorChooserDemo extends JFrame {
	private JPanel p;
	// 声明颜色选取器
	private JColorChooser ch;
	// 声明一个存放颜色的对话框
	private JDialog colorDialog;
	private JButton btnChange;

	public JColorChooserDemo() {
		super("颜色对话框");
		p = new JPanel();
		// 实例化颜色选取器对象
		ch = new JColorChooser();
		// 创建一个颜色对话框，颜色选取器对象作为其中的一个参数
		colorDialog = JColorChooser.createDialog(this, "选取颜色", true, ch, null,
				null);
		btnChange = new JButton("改变面板背景颜色");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示颜色对话框
				colorDialog.setVisible(true);
				// 设置面板背景颜色为用户选取的颜色
				p.setBackground(ch.getColor());
			}
		});

		p.add(btnChange);

		// 将面板添加到窗体
		this.add(p);
		// 设定窗口大小
		this.setSize(800, 600);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JColorChooserDemo();
	}
}
