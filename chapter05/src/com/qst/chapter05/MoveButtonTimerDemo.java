package com.qst.chapter05;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//使用java.util.Timer完成按钮移动
public class MoveButtonTimerDemo extends JFrame {
	JPanel p;
	JButton btnMove;

	// 声明一个Timer
	Timer t;

	// 按钮移动距离
	int movex = 5;
	int movey = 5;

	public MoveButtonTimerDemo() {
		super("按钮移动（Timer方式）");
		p = new JPanel(null);
		btnMove = new JButton("移动");
		btnMove.setBounds(0, 100, 80, 25);

		p.add(btnMove);
		this.add(p);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 2. 实例化Timer对象
		t = new Timer();

		// 3.调用schedule()方法，执行任务
		t.schedule(new ButtonMoveTask(), 0, 100);
	}

	// 1. 定义一个内部类，继承TimerTask
	class ButtonMoveTask extends TimerTask {
		// 任务方法
		public void run() {
			// 获取按钮x轴坐标,并增加movex
			int x = btnMove.getX() + movex;
			// 获取按钮y轴坐标,并增加movey
			int y = btnMove.getY() + movey;
			if (x <= 0) {
				// 最小值
				x = 0;
				// 换方向
				movex = -movex;
			} else if (x >= MoveButtonTimerDemo.this.getWidth()
					- btnMove.getWidth()) {
				// 最大值,窗口的宽度-按钮的宽度
				x = MoveButtonTimerDemo.this.getWidth() - btnMove.getWidth();
				// 换方向
				movex = -movex;
			}
			if (y <= 0) {
				// 最小值
				y = 0;
				// 换方向
				movey = -movey;
			} else if (y >= MoveButtonTimerDemo.this.getHeight() - 30
					- btnMove.getHeight()) {
				// 最大值,窗口的高度-标题栏的高度-按钮的高度
				y = MoveButtonTimerDemo.this.getHeight() - 30
						- btnMove.getHeight();
				// 换方向
				movey = -movey;
			}
			// 设置按钮坐标为新的坐标
			btnMove.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		MoveButtonTimerDemo f = new MoveButtonTimerDemo();
		f.setVisible(true);
	}
}
