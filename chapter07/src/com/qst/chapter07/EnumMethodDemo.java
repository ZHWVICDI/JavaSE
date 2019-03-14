package com.qst.chapter07;
//java.lang.Enum���ʹ�ü�����
public class EnumMethodDemo {

	public static void main(String[] args) {
		System.out.println("SeasonEnumö���������ʵ��ֵ�Լ�˳��ţ�");
		// ���SeasonEnum���ʵ��ֵ�Լ�˳���
		for (SeasonEnum s : SeasonEnum.values()) {
			System.out.println(s + "--" + s.ordinal());
		}
		System.out.println("---------------------");
		// ����4��SeasonEnum����
		SeasonEnum s1, s2, s3, s4;
		// ��ֵ
		s1 = SeasonEnum.SPRING;
		s2 = SeasonEnum.SUMMER;
		s3 = SeasonEnum.FALL;
		// ����Enum��ľ�̬������ȡָ��ö���͡�ָ��ֵ��ö��ʵ��
		s4 = Enum.valueOf(SeasonEnum.class, "FALL");
		// �ȼ���
		// s4 = SeasonEnum.valueOf("FALL");

		// ʹ��compareTo()���бȽ�		//���䣻����Ƚϵ�����š�
		if (s1.compareTo(s2) < 0) {
			System.out.println(s1 + "��" + s2 + "֮ǰ");
		}
		// ʹ��equals()�ж�				//���䣺����Ƚϵ���ֵ��
		if (s3.equals(s4)) {
			System.out.println(s3 + "����" + s4);
		}
		// ʹ��==�ж�						//���䣺??????
		if (s3 == s4) {
			System.out.println(s3 + "==" + s4);
		}
		System.out.println("---------------------");

		System.out.println("SeasonEnum2ö���������ʵ��ֵ�Լ�˳��ţ�");
		// ���SeasonEnum���ʵ��ֵ�Լ�˳���
		for (SeasonEnum2 s : SeasonEnum2.values()) {
			System.out.println(s + "--" + s.ordinal());
		}
		System.out.println("---------------------");
		// ����4��SeasonEnum����
		SeasonEnum2 se1, se2, se3, se4;
		// ��ֵ
		se1 = SeasonEnum2.SPRING;
		se2 = SeasonEnum2.SUMMER;
		se3 = SeasonEnum2.FALL;
		// ����Enum��ľ�̬������ȡָ��ö���͡�ָ��ֵ��ö��ʵ��
		se4 = Enum.valueOf(SeasonEnum2.class, "FALL");
		// �ȼ���
		// se4 = SeasonEnum2.valueOf("FALL");

		// ʹ��compareTo()���бȽ�
		if (se1.compareTo(se2) < 0) {
			System.out.println(se1 + "��" + se2 + "֮ǰ");
		}
		// ʹ��equals()�ж�
		if (se3.equals(se4)) {
			System.out.println(se3 + "����" + se4);
		}
		// ʹ��==�ж�
		if (se3 == se4) {
			System.out.println(se3 + "==" + se4);
		}

	}

}
