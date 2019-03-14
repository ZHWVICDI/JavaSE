package com.qst.chapter05;

//使用同步锁的方式		实现线程同步
//同样的同步锁是放在线程安全的方法中。
//每次只能有一个线程对Lock对象加锁，且线程访问共享资源前需要获得Lock对象。
public class SynLockBank extends Thread {
	// 银行账户
	private BankAccountSynLock account;
	// 操作金额，正数为存钱，负数为取钱
	private double money;

	public SynLockBank(String name, BankAccountSynLock account, double money) {
		super(name);
		this.account = account;
		this.money = money;
	}

	// 线程任务
	public void run() {
		// 调用account对象的access()方法
		this.account.access(money);
	}

	public static void main(String[] args) {
		// 创建一个银行账户实例
		BankAccountSynLock myAccount = new BankAccountSynLock("60001002", 5000);
		// 创建多个线程，对账户进行存取钱操作
		SynLockBank t1 = new SynLockBank("T001", myAccount, -3000);
		SynLockBank t2 = new SynLockBank("T002", myAccount, -3000);
		SynLockBank t3 = new SynLockBank("T003", myAccount, 1000);
		SynLockBank t4 = new SynLockBank("T004", myAccount, -2000);
		SynLockBank t5 = new SynLockBank("T005", myAccount, 2000);

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
