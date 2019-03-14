package com.qst.chapter05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//使用线程完成按钮移动
public class MoveButtonThreadDemo extends JFrame implements Runnable {
	JPanel p;
	JButton btnMove;
	
	//声明一个线程对象t
	Thread t;
	
	//按钮移动距离
	int movex = 5;
	int movey = 5;

	public MoveButtonThreadDemo() {
		super("按钮移动（线程方式）");
		p = new JPanel(null);
		btnMove = new JButton("移动");
		btnMove.setBounds(0, 100, 80, 25);

		p.add(btnMove);
		this.add(p);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 创建线程对象
		t = new Thread(this);
		// 线程启动
		t.start();
	}

	// 实现run()方法
	public void run() {
		while (t.isAlive()) {
			// 获取按钮x轴坐标,并增加movex
			int x = btnMove.getX() + movex;
			// 获取按钮y轴坐标,并增加movey
			int y = btnMove.getY() + movey;
			if (x <= 0) {
				// 最小值
				x = 0;
				// 换方向
				movex = -movex;
			} else if (x >= this.getWidth() - btnMove.getWidth()) {
				// 最大值,窗口的宽度-按钮的宽度
				x = this.getWidth() - btnMove.getWidth();
				// 换方向
				movex = -movex;
			}
			if (y <= 0) {
				// 最小值
				y = 0;
				// 换方向
				movey = -movey;
			} else if (y >= this.getHeight() - 30 - btnMove.getHeight()) {
				// 最大值,窗口的高度-标题栏的高度-按钮的高度
				y = this.getHeight() - 30 - btnMove.getHeight();
				// 换方向
				movey = -movey;
			}
			// 设置按钮坐标为新的坐标
			btnMove.setLocation(x, y);
			try {
				// 休眠100毫秒
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MoveButtonThreadDemo f = new MoveButtonThreadDemo();
		f.setVisible(true);
	}
}
