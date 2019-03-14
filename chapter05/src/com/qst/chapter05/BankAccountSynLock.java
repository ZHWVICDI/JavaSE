package com.qst.chapter05;

import java.util.concurrent.locks.ReentrantLock;

//银行帐户
//同步锁的方式
public class BankAccountSynLock {
	// 银行账号
	private String bankNo;
	// 银行余额
	private double balance;

	// 1.定义锁对象
	private final ReentrantLock lock = new ReentrantLock();

	// 构造方法
	public BankAccountSynLock(String bankNo, double balance) {
		this.bankNo = bankNo;
		this.balance = balance;
	}

	// 存取钱操作
	public void access(double money) {
		//2. 加锁
		lock.lock();
		try {
			// 如果操作的金额money<0,则代表取钱操作,同时判断账户金额是否低于取钱金额
			if (money < 0 && balance < -money) {
				System.out.println(Thread.currentThread().getName()
						+ "操作失败，余额不足！");
				// 返回
				return;
			} else {
				// 对账户金额进行操作
				balance += money;
				System.out.println(Thread.currentThread().getName()
						+ "操作成功，目前账户余额为：" + balance);
				try {
					// 休眠1毫秒
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			//3. 释放锁
			lock.unlock();
		}
	}

	// getter/setter方法
	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
