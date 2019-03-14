package com.qst.chapter05;

//使用同步代码块的方式 补充：实现线程同步
public class SynBlockBank extends Thread {
	// 银行账户
	private BankAccount account;
	// 操作金额，正数为存钱，负数为取钱
	private double money;

	public SynBlockBank(String name, BankAccount account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}

	// 线程任务	
	public void run() {
		//补充：语法	 synchronized(object){}	object：同步监视器，请选用线程共享的对象。
		synchronized (this.account) {
			// 获取目账户的金额
			double d = this.account.getBalance();
			// 如果操作的金额money<0,则代表取钱操作,同时判断账户金额是否低于取钱金额
			if (money < 0 && d < -money) {
				System.out.println(this.getName() + "操作失败，余额不足！");
				// 返回
				return;
			} else {
				// 对账户金额进行操作
				d += money;
				System.out.println(this.getName() + "操作成功，目前账户余额为：" + d);
				try {
					// 休眠1毫秒
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改账户金额
				this.account.setBalance(d);

			}
		}
	}

	public static void main(String[] args) {
		// 创建一个银行账户实例
		BankAccount myAccount = new BankAccount("60001002", 5000);
		// 创建多个线程，对账户进行存取钱操作
		SynBlockBank t1 = new SynBlockBank("T001", myAccount, -3000);
		SynBlockBank t2 = new SynBlockBank("T002", myAccount, -3000);
		SynBlockBank t3 = new SynBlockBank("T003", myAccount, 1000);
		SynBlockBank t4 = new SynBlockBank("T004", myAccount, -2000);
		SynBlockBank t5 = new SynBlockBank("T005", myAccount, 2000);

		// 启动线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// 等待所有子线程完成
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 输出账户信息
		System.out.println("账号：" + myAccount.getBankNo() + ", 余额："
				+ myAccount.getBalance());
	}

}
