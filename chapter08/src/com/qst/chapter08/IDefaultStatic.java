package com.qst.chapter08;
//java8�����ԣ�����ӿ��ж���Ĭ�Ϸ����;�̬������
public interface IDefaultStatic {
	// ���󷽷�		
	double calculate(int a);

	// Ĭ�Ϸ���			//���䣺defaultǰ׺	����ͨ���ӿڷ��ʣ�ֻ��ͨ���ӿ���ʵ��������
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	// ��̬����			//���䣺staticǰ׺	����ͨ���ӿ������ʣ�Ҳ����ͨ���ӿ���ʵ������
	static String msg() {
		return "�ӿ��еľ�̬����";
	}

}
