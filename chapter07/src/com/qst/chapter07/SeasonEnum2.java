package com.qst.chapter07;
//���䣺�������Ժͷ�����ö����
//�����췽����ö����
public enum SeasonEnum2 {
	// �ڵ�һ���г�4��ö��ʵ��:�����ġ����			//���䣺����ͬ������ͨ����ù��췽��ʱ���ơ�
	SPRING("��"), SUMMER("��"), FALL("��"), WINTER("��");
	// ����һ������
	private String name;

	// ���췽��		//���ڸ�ʵ��name���Ը�ֵ��
	SeasonEnum2(String name) {
		this.name = name;
	}

	// ����
	public String toString() {
		return this.name;
	}
}
