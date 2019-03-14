package com.qst.chapter03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelDemo extends JFrame {
	// 声明一个面板对象
	private JPanel p;
	// 声明两个按钮对象
	private JButton btnOk, btnCancel;

	public JPanelDemo() {
		super("JPanelDemo");

		// 实例化面板对象p（默认为流布局）
		p = new JPanel();

		// 实例化一个按钮对象，该按钮上的文本为“确认”
		btnOk = new JButton("确认");
		// 实例化一个按钮对象，该按钮上的文本为“取消”
		btnCancel = new JButton("取消");

		// 将按钮添加到面板中
		p.add(btnOk);
		p.add(btnCancel);

		// 将面板添加到窗体中
		this.add(p);

		// 设定窗口大小（宽度400像素，高度300像素）
		this.setSize(400, 300);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JPanelDemo();
	}

}
