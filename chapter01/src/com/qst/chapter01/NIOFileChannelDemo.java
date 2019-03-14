package com.qst.chapter01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class NIOFileChannelDemo {
//���䣺ͨ���ֽ�������ȡͨ����Ȼ��ͨ��ͨ���õ�buffer����ʵ�ֶ�ȡ�ļ��� buffer����ͨ��channel������д�뵽�ֽ����С�ʵ��д���ļ���
	public static void main(String[] args) {
		File f = new File("src\\com\\qst\\chapter01\\NIOFileChannelDemo.java");
		try (
		// ����FileInputStream��ͨ�����ļ�����������FileChannel
		FileChannel inChannel = new FileInputStream(f).getChannel();
				// ���ļ����������FileBuffer�����Կ������
				FileChannel outChannel = new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\channel.txt")
						.getChannel()) {
			// ��FileChannel���ȫ������ӳ���ByteBuffer	���䣺inChannel.map(FileChannel,MapMode,long position,long size) ���ã�����ͨ�����ļ�����ֱ��ӳ�䵽�ڴ�
			MappedByteBuffer buffer = inChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, f.length()); // ��
			// ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			
			// ֱ�ӽ�buffer������ӳ�䵽�ڴ��е����ݣ��������ȫ�����	���䣺�����Ƕ�buffer����ͨ��Channelд�뵽FileOutputStream��ȥ��outChannel.write(ByteBuffer src)	���ã����ֽ����дӸ����Ļ�����д��ͨ��outChannel
			outChannel.write(buffer); // ��
			// �ٴε���buffer��clear()��������ԭlimit��position��λ��//���䣺������Ƕ�Buffer����Ķ�
			
			
			buffer.clear();
			// ����������(CharsetDecoder)����
			CharsetDecoder decoder = charset.newDecoder();
			// ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			// CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
