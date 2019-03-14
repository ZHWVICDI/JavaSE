package com.qst.chapter03;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageIconDemo extends JFrame {
	public ImageIconDemo() {
		super("ImageIcon图标");
		
	    //创建ImageIcon图标
		ImageIcon qstIcon=new ImageIcon("images\\qst.png");
		
		//设置窗体的Icon
		this.setIconImage(qstIcon.getImage());
	
		// 设定窗口大小（宽度400像素，高度300像素）
		this.setSize(400, 300);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		 //创建ImageIcon图标
		ImageIcon booksIcon =new ImageIcon("images\\books.jpg");
		//在窗体中画图标
	    g.drawImage(booksIcon.getImage(), 0, 20, this);
	    //显示图标的宽度和高度
	    g.drawString("宽:"+booksIcon.getIconWidth()+"px，高:"+booksIcon.getIconHeight()+"px", 20,210);
	}
	public static void main(String[] args) {
		new ImageIconDemo();
	}

}
