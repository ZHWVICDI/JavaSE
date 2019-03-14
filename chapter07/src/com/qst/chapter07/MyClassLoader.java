package com.qst.chapter07;

import java.io.File;
import java.io.FileInputStream;

class Animal {
	public void say() {
		System.out.println("����һ��Animal��");
	}
}
//���䣺ͨ���̳�ClassLoader�ಢ��дfindClass������loadClass������ʵ���Զ�������������
//���䣺findClass����ʵ���Լ���������ԣ�loadClass����ʵ���Լ����������
//���䣺������дloadClass����ʵ���߼�ʮ�ָ��ӣ�����дfindClass�����ܹ����⸲��Ĭ����������ĸ���ί�С�����������ֲ��ԣ������Ƽ���дfindClass������
public class MyClassLoader extends ClassLoader {
	/**
	 * ��дfindClass()����
	 */
	public Class<?> findClass(String className) {
		byte[] data = loadClassData(className);
		// ����ClassLoader��defineClass����������������ת����Class����
		return this.defineClass(className, data, 0, data.length);
	}
	//���䣺�÷������ڶ�ȡclass�������ļ�������
	public byte[] loadClassData(String className) {
		try {
			// ��ȡ��ȡ��ǰ��Ŀ·��
			String path = this.getClass().getResource("/").getPath();
			path = path.substring(1);
			//���䣺com.qst.chapter07.Animal->com/qst/chapter07/Animal.class
			className = className.replace(".", "/");
			//class�ļ�����·��	
			File classfile = new File(path+className + ".class");
			long len = classfile.length();
			byte[] raw = new byte[(int) len];
			FileInputStream fin = new FileInputStream(classfile);
			// һ�ζ�ȡclass�ļ���ȫ������������
			int r = fin.read(raw);
			if (r != len) {
				System.out.println("�޷���ȡȫ���ļ�!");
				return null;
			} else {
				return raw;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		// �½�һ���������
		MyClassLoader mcl = new MyClassLoader(); 
		
		// �����࣬�õ�Class����
		Class<?> clazz = mcl.loadClass("com.qst.chapter07.Animal");
		
		// ��ȡ���ʵ��
		Animal animal = (Animal) clazz.newInstance();
		animal.say();
	}
}
