package com.qst.chapter05;

//使用同步方法的方式  	实现线程同步
//补充：同步方法是放在共享对象中的，同步方法的同步监视器是this，即方法所属的对象。
//补充：线程安全的类：即具有同步方法的类。
public class SynMethodBank extends Thread {
	// 银行账户
	private BankAccountSynMethod account;
	// 操作金额，正数为存钱，负数为取钱
	private double money;

	public SynMethodBank(String name, BankAccountSynMethod account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}
	// 线程任务
	public void run() {
         //调用account对象的同步方法		
		this.account.access(money);
	}

	public static void main(String[] args) {
		// 创建一个银行账户实例
		BankAccountSynMethod myAccount = new BankAccountSynMethod("60001002", 5000);
		// 创建多个线程，对账户进行存取钱操作
		SynMethodBank t1 = new SynMethodBank("T001", myAccount, -3000);
		SynMethodBank t2 = new SynMethodBank("T002", myAccount, -3000);
		SynMethodBank t3 = new SynMethodBank("T003", myAccount, 1000);
		SynMethodBank t4 = new SynMethodBank("T004", myAccount, -2000);
		SynMethodBank t5 = new SynMethodBank("T005", myAccount, 2000);

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
