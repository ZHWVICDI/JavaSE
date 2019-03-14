package com.qst.chapter05;
//线程生命周期的演示。
class MyThread extends Thread {
	public void run() {
		int sum=0;
		for(int i=0;i<1000;i++){
			sum+=i;
		}
		System.out.println("子线程求和："+sum);
	}
}

public class ThreadLifeDemo {

	public static void main(String[] args) throws Exception {
		MyThread thread1 = new MyThread();
		//补充：判断线程是否处于运行状态 	 t.isAlive()
		System.out.println("新建状态[isAlive: " + thread1.isAlive() + "]");
		
		//线程启动
		thread1.start();	
		System.out.println("运行状态[isAlive: " + thread1.isAlive() + "]");
		
		//线程休眠1000毫秒（即1秒）	补充：Thread.sleep(毫秒数)	注意要放在trycatch块中
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程结束[isAlive: " + thread1.isAlive() + "]");
	}

}
