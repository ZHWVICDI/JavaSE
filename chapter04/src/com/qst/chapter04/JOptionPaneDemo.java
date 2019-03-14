package com.qst.chapter04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JOptionPaneDemo extends JFrame {
	private JPanel p;
	private JTextArea txtContent;
	private JButton btnInput, btnMsg, btnConfirm, btnOption;

	public JOptionPaneDemo() {
		super("JOptionPane标准对话框");

		p = new JPanel();

		btnInput = new JButton("输入");
		btnMsg = new JButton("消息");
		btnConfirm = new JButton("确认");
		btnOption = new JButton("选项");
		txtContent = new JTextArea(20, 10);

		// 注册监听
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示输入对话框，并返回用户输入的字符串
				String strIn = JOptionPane
						.showInputDialog(btnInput, "请输入一个数字：");
				try {
					int num = Integer.parseInt(strIn.trim());
					// 在文本域中追加内容
					txtContent.append(num + " * " + num + " = " + (num * num)
							+ "\n");
				} catch (NumberFormatException e1) {
					txtContent.append(strIn + "不是数字，请重新输入！\n");
				}
			}
		});
		btnMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示消息对话框
				JOptionPane.showMessageDialog(btnMsg, "下午两点开QST员工大会！", "消息",
						JOptionPane.INFORMATION_MESSAGE);
				txtContent.append("显示消息对话框！\n");
			}
		});
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示确认对话框
				int r = JOptionPane.showConfirmDialog(btnConfirm, "您确定要删除吗？",
						"确认", JOptionPane.YES_NO_OPTION);
				if (r == JOptionPane.YES_OPTION) {
					txtContent.append("显示确认对话框！您选择了'是'\n");
				} else {
					txtContent.append("显示确认对话框！您选择了'否'\n");
				}

			}
		});
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Red", "Green", "Blue" };
				// 显示选择对话框
				int sel = JOptionPane.showOptionDialog(btnOption, "选择颜色：",
						"选择", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (sel != JOptionPane.CLOSED_OPTION) {
					txtContent.append("显示选择对话框！颜色: " + options[sel] + "\n");
				}

			}
		});

		// 将按钮添加到面板中
		p.add(btnInput);
		p.add(btnMsg);
		p.add(btnConfirm);
		p.add(btnOption);

		// 将文本域添加到窗口中央
		this.add(txtContent);
		// 将面板添加到窗体南面
		this.add(p, BorderLayout.SOUTH);
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
		new JOptionPaneDemo();
	}
}
