package com.qst.chapter07;
//ʹ�ô����췽����ö����
public class SeasonEnum2Demo {
	public static void main(String[] args) {
		System.out.println("SeasonEnum2ö���������ʵ��ֵ��");
		// ö����Ĭ����һ��values���������ظ�ö���������ʵ��ֵ
		for (SeasonEnum2 s : SeasonEnum2.values()) {
			//���䣺��Ϊ������д�˸�ö�����toString�����������������name��
			System.out.println(s);
		}
		System.out.println("---------------------");

		// ʹ��valueOf()������ȡָ����ʵ��			//���䣺ö����.valueOf��ö��ʵ������	���ܣ���ȡָ��ʵ����������ʵ����������ֵ��ö�ٶ���
		SeasonEnum2 se = SeasonEnum2.valueOf("SUMMER");
		// ���se
		System.out.println(se);
		// ����judge()����
		judge(se);
		System.out.println("---------------------");

		// ����һ��ö�������,��ֱ�Ӹ�ֵ		//���䣺����Ĺ��췽��������д��ö��������ġ�
		SeasonEnum2 season = SeasonEnum2.WINTER;
		// ���season
		System.out.println(season);

		// ����judge()����
		judge(season);

	}

	// �жϼ��ڲ����
	private static void judge(SeasonEnum2 season) {
		// ʹ��switch����ж�ö��ֵ
		switch (season) {
		case SPRING:
			System.out.println("��ů����������̤��");
			break;
		case SUMMER:
			System.out.println("�������ף��ʺ���Ӿ");
			break;
		case FALL:
			System.out.println("�����ˬ��������ʱ");
			break;
		case WINTER:
			System.out.println("����ѩƮ��Χ¯��ѩ");
			break;
		}
	}

}
