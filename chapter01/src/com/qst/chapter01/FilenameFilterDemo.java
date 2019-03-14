package com.qst.chapter01;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {
/*FilenameFilter�ӿڵ�ʹ�ã�����һ����ʵ�ֽӿڵ�accept()����,����ֱ��ʹ��һ����������ʵ�֡�
 * 
 * */
	public static void main(String[] args) {
		// ����·�����ƴ���File����
		File file = new File("E:\\Program Files\\Java\\jre1.8.0_181");
		// �õ��ļ����б�
		if (file.exists() && file.isDirectory()) {
			// ��ʾ��Ŀ¼�������ļ��б�
			String[] allFileNames = file.list();
			
			for (String name : allFileNames) {
				System.out.println(name);
			}
			System.out.println("--------------------");

			// ����FileNameFilter���͵������࣬����Ϊ�������뵽list()������;���䣺java���������Զ�����һ������ʵ�ֽӿ�
			String[] filterFileNames = file.list(new FilenameFilter() {
				//��дFilenameFilter�ṩ��accept(File dir,String name)������ʵ�ָýӿ�:File������Ŀ¼��name�������ļ���
				public boolean accept(File dir, String name) {
					// ���ļ������й��ˣ��ļ����ĺ�׺Ϊ.zip��.txt
					return (name.endsWith(".zip") || name.endsWith(".txt"));
				}
			});
			System.out.println("���˺���ļ��б�");
			for (String name : filterFileNames) {
				System.out.println(name);
			}
		}

	}

}
