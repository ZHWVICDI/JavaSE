package com.qst.chapter04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChooserDemo extends JFrame {
	private JPanel p;
	private JScrollPane sp;
	private JTextArea txtContent;
	private JButton btnOpen, btnSave, btnClear;

	public JFileChooserDemo() {
		super("JFileChooser文件对话框");

		p = new JPanel();

		btnOpen = new JButton("打开");
		btnSave = new JButton("保存");
		btnClear = new JButton("清空");

		txtContent = new JTextArea(20, 10);
		// 创建加载文本域的滚动面板
		sp = new JScrollPane(txtContent);

		// 注册监听
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 清空文本域
				txtContent.setText("");
			}
		});

		// 将按钮添加到面板中
		p.add(btnOpen);
		p.add(btnSave);
		p.add(btnClear);

		// 将滚动面板添加到窗口中央
		this.add(sp);
		// 将面板添加到窗体南面
		this.add(p, BorderLayout.SOUTH);
		// 设定窗口大小
		this.setSize(600, 500);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	// 打开文件的方法
	private void openFile() {
		// 实例化一个文件对话框对象
		JFileChooser fc = new JFileChooser();
		// 显示文件打开对话框
		int rVal = fc.showOpenDialog(this);
		// 如果点击确定(Yes/OK)
		if (rVal == JFileChooser.APPROVE_OPTION) {
			// 获取文件对话框中用户选中的文件名
			String fileName = fc.getSelectedFile().getName();
			// 获取文件对话框中用户选中的文件所在的路径
			String path = fc.getCurrentDirectory().toString();
			try {
				// 创建一个文件输入流，用于读文件
				FileReader fread = new FileReader(path + "/" + fileName);
				// 创建一个缓冲流
				BufferedReader bread = new BufferedReader(fread);
				// 从文件中读一行信息
				String line = bread.readLine();
				// 循环读文件中的内容，并显示到文本域中
				while (line != null) {
					txtContent.append(line + "\n");
					// 读下一行
					line = bread.readLine();
				}
				bread.close();
				fread.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 保存文件的方法
	private void saveFile() {
		// 实例化一个文件对话框对象
		JFileChooser fc = new JFileChooser();
		// 显示文件保存对话框
		int rVal = fc.showSaveDialog(this);
		// 如果点击确定(Yes/OK)
		if (rVal == JFileChooser.APPROVE_OPTION) {
			// 获取文件对话框中用户选中的文件名
			String fileName = fc.getSelectedFile().getName();
			// 获取文件对话框中用户选中的文件所在的路径
			String path = fc.getCurrentDirectory().toString();
			try {
				// 创建一个文件输出流，用于写文件
				FileWriter fwriter = new FileWriter(path + "/" + fileName);
				// 将文本域中的信息写入文件中
				fwriter.write(txtContent.getText());
				fwriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new JFileChooserDemo();
	}
}
