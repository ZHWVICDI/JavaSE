package com.qst.chapter04;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class JTreeDemo extends JFrame {
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	private JTextArea textArea;
	private JPanel p;

	public JTreeDemo() {
		super("JTree树");

		// 实例化树的根节点
		root = makeSampleTree();
		// 实例化的树模型
		model = new DefaultTreeModel(root);
		// 实例化一棵树
		tree = new JTree(model);
		// 设置树的选择模式是单一节点的选择模式（一次只能选中一个节点）
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		// 注册树的监听对象，监听选择不同的树节点
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			// 重写 树的选择事件处理方法
			public void valueChanged(TreeSelectionEvent event) {
				// 获取选中节点的路径
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				// 获取选中的节点对象
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				// 获取选中节点的内容，并显示到文本域中
				textArea.setText(selectedNode.getUserObject().toString());
			}
		});

		// 实例化一个面板对象，布局是1行2列
		p = new JPanel(new GridLayout(1, 2));
		// 在面板的左侧放置树
		p.add(new JScrollPane(tree));
		textArea = new JTextArea();
		// 面板右侧放置文本域
		p.add(new JScrollPane(textArea));

		// 将面板添加到窗体
		this.add(p);
		// 设定窗口大小
		this.setSize(400, 300);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	// 创建一棵树对象的方法
	public DefaultMutableTreeNode makeSampleTree() {
		// 实例化树节点，并将节点添加到相应节点中
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("QST青软实训");
		DefaultMutableTreeNode comp = new DefaultMutableTreeNode("人力资源服务有限公司");
		root.add(comp);
		DefaultMutableTreeNode dpart = new DefaultMutableTreeNode("研发部");
		comp.add(dpart);
		DefaultMutableTreeNode emp = new DefaultMutableTreeNode("赵克玲");
		dpart.add(emp);
		emp = new DefaultMutableTreeNode("张三");
		dpart.add(emp);
		dpart = new DefaultMutableTreeNode("教学部");
		comp.add(dpart);
		emp = new DefaultMutableTreeNode("李四");
		dpart.add(emp);
		return root;
	}

	public static void main(String[] args) {
		new JTreeDemo();
	}
}
