package com.qst.chapter04;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JDialogDemo extends JFrame {
	JPanel p;
	JButton btnMod, btnNon, btnMy;
	// 声明两个对话框组件
	JDialog modDialog, nonDialog;
	// 声明自定义的对话框组件
	MyDialog myDialog;

	public JDialogDemo() {
		super("测试对话框");

		p = new JPanel();
		btnMod = new JButton("模式对话框");
		btnNon = new JButton("非模式对话框");
		btnMy = new JButton("自定义对话框");

		// 创建模式对话框
		modDialog = new JDialog(this, "模式对话框", true);
		// 设置对话框的坐标和大小
		modDialog.setBounds(250, 200, 200, 100);

		// 创建非模式对话框
		nonDialog = new JDialog(this, "非模式对话框", false);
		// 设置对话框的坐标和大小
		nonDialog.setBounds(250, 200, 200, 100);

		// 创建自定义对话框
		myDialog = new MyDialog(this);

		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示模式对话框
				modDialog.setVisible(true);
			}
		});
		btnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示非模式对话框
				nonDialog.setVisible(true);
			}
		});
		btnMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示自定义对话框
				myDialog.setVisible(true);
			}
		});

		p.add(btnMod);
		p.add(btnNon);
		p.add(btnMy);

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
		new JDialogDemo();
	}

}

// 创建一个对话框类，继承JDialog类
class MyDialog extends JDialog {
	// 声明对话框中的组件
	JPanel p;
	JLabel lblNum;
	JTextField txtNum;
	JButton btnOK;

	public MyDialog(JFrame f) {
		super(f, "我的对话框", true);
		// 创建对话框中的组件
		p = new JPanel();
		lblNum = new JLabel("请输入一个数：");
		txtNum = new JTextField(10);
		btnOK = new JButton("确定");

		// 注册监听
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(txtNum.getText().trim());
					System.out.println(num + " * " + num + " = " + (num * num));
				} catch (NumberFormatException e1) {
					System.out.println(txtNum.getText()+"不是数字，请重新输入！");
					// 清空文本框
					txtNum.setText("");
				}
			}
		});

		// 将组件添加到面板中
		p.add(lblNum);
		p.add(txtNum);
		p.add(btnOK);
		// 将面板添加到对话框中
		this.add(p);
		// 设置对话框合适的大小
		this.pack();
		// 设置对话框的坐标
		this.setLocation(250, 200);
	}
}
