package com.qst.chapter07;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
//Feild��Ļ�ȡ���䷽��
class Person {
	private String name;
	private int age;
	private String address;

	public String toString() {
		return "[name:" + name + " , age:" + age + " , address:" + address
				+ " ]";
	}
}

public class FieldDemo {

	public static void main(String[] args) {
		try {
			// ��ȡPerson���Ӧ��Class����
			Class<Person> personClazz = Person.class;
			System.out.println("--------Person�������--------");
			// �����������������԰���˽�еĺ��ܱ����ģ�����������������			//���䣺�������ʹ��getFields�������ǰ����������ԡ�
			Field[] fields = personClazz.getDeclaredFields();
			for (Field f : fields) {
				// ��ȡ���Ե����η�
				int mod = f.getModifiers();
				// ʹ��Modifier������ķ��������ʵ�����η�,�����
				System.out.print(Modifier.toString(mod));

				// ��ȡ���Ե�����,�����
				Class type = f.getType();
				System.out.print(" " + type.getName());

				// ��ȡ���Ե�����,�����
				System.out.println(" " + f.getName());
			}

			// ����һ��Person����
			Person p = new Person();

			// ʹ��getDeclaredField()���������ɻ�ȡ���ַ��ʿ��Ʒ��ĳ�Ա����
			// ��ȡPerson���name���Զ���				//���䣺��Ϊ������ֵ
			Field nameField = personClazz.getDeclaredField("name");
			// ����ͨ��������ʸó�Ա����ʱȡ������Ȩ�޼��
			nameField.setAccessible(true);
			// Ϊp�����name��������ֵ����String���������ͣ�����ֱ��ʹ��set()����
			nameField.set(p, "�Կ���");

			// ��ȡPerson���age���Զ���				//���䣺��Ϊ������ֵ
			Field ageField = personClazz.getDeclaredField("age");
			// ����ͨ��������ʸó�Ա����ʱȡ������Ȩ�޼��
			ageField.setAccessible(true);
			// ����setInt()����Ϊp�����age��������ֵ
			ageField.setInt(p, 36);

			// ��ȡPerson���address���Զ���			//���䣺��Ϊ������ֵ
			Field addressField = personClazz.getDeclaredField("address");
			// ����ͨ��������ʸó�Ա����ʱȡ������Ȩ�޼��
			addressField.setAccessible(true);
			// Ϊp�����name��������ֵ����String���������ͣ�����ֱ��ʹ��set()����
			addressField.set(p, "�ൺ");

			// �������p����Ϣ
			System.out.println("--------Personʵ��--------");
			System.out.println(p);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
