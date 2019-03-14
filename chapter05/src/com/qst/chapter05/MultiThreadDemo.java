package com.qst.chapter05;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiThreadDemo extends JFrame {

	JPanel p;
	JLabel lblTitle;
	JButton btnMove;
	String s[] = { "QST青软实训", "锐聘学院", "在实践中成长丛书" };
	int index = 0;
	int movex = 5;

	public MultiThreadDemo() {
		super("多线程多任务");
		p = new JPanel(null);
		lblTitle = new JLabel(s[0]);
		// 设置标签字体
		lblTitle.setFont(new Font("黑体", Font.BOLD, 28));

		btnMove = new JButton("QST欢迎您！");

		// 设置坐标
		lblTitle.setBounds(80, 50, 250, 50);
		btnMove.setBounds(0, 150, 120, 25);

		p.add(lblTitle);
		p.add(btnMove);
		this.add(p);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 创建子线程ColorChange，并启动
		new ColorChange().start();
		// 创建java.util.Timer对象，并安排任务，每隔1秒变换文本
		new java.util.Timer().schedule(new TextChange(), 0, 1000);
		// javax.swing.Timer对象，，并启动，让按钮每隔100毫秒水平移动一次
		new javax.swing.Timer(100, new ButtonMoveListener()).start();
	}

	// 1、定义子线程，让窗口背景颜色不断变化
	class ColorChange extends Thread {
		public void run() {
			while (this.isAlive()) {
				// 随机产生颜色的3个基数0~255
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);
				// 设置面板的背景颜色
				p.setBackground(new Color(r, g, b));
				try {
					// 休眠1秒钟
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 2. 定义内部类，继承TimerTask，让标签文本不断变化
	class TextChange extends TimerTask {
		// 任务方法
		public void run() {
			lblTitle.setText(s[index++]);
			if (index == s.length) {
				index = 0;
			}
		}
	}

	// 3. 定义一个监听类，实现按钮左右移动
	class ButtonMoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 获取按钮x轴坐标,并增加movex
			int x = btnMove.getX() + movex;
			if (x <= 0) {
				// 最小值
				x = 0;
				// 换方向
				movex = -movex;
			} else if (x >= getWidth() - btnMove.getWidth()) {
				// 最大值,窗口的宽度-按钮的宽度
				x = getWidth() - btnMove.getWidth();
				// 换方向
				movex = -movex;
			}
			btnMove.setLocation(x, btnMove.getY());
		}
	}

	public static void main(String[] args) {
		MultiThreadDemo f = new MultiThreadDemo();
		f.setVisible(true);
	}
}
