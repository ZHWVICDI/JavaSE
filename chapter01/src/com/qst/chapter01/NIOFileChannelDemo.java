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
//补充：通过字节流来获取通道，然后通过通道得到buffer对象。实现读取文件。 buffer对象通过channel，又再写入到字节流中。实现写入文件。
	public static void main(String[] args) {
		File f = new File("src\\com\\qst\\chapter01\\NIOFileChannelDemo.java");
		try (
		// 创建FileInputStream，通过该文件输入流创建FileChannel
		FileChannel inChannel = new FileInputStream(f).getChannel();
				// 以文件输出流创建FileBuffer，用以控制输出
				FileChannel outChannel = new FileOutputStream("D:\\JAVA\\java_module\\chapter01\\src\\com\\qst\\data\\channel.txt")
						.getChannel()) {
			// 将FileChannel里的全部数据映射成ByteBuffer	补充：inChannel.map(FileChannel,MapMode,long position,long size) 作用：将该通道的文件区域直接映射到内存
			MappedByteBuffer buffer = inChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, f.length()); // ①
			// 使用GBK的字符集来创建解码器
			Charset charset = Charset.forName("GBK");
			
			// 直接将buffer（我们映射到内存中的数据）里的数据全部输出	补充：这里是对buffer对象通过Channel写入到FileOutputStream中去。outChannel.write(ByteBuffer src)	作用：讲字节序列从给定的缓存区写入通道outChannel
			outChannel.write(buffer); // ②
			// 再次调用buffer的clear()方法，复原limit、position的位置//补充：下面就是对Buffer对象的读
			
			
			buffer.clear();
			// 创建解码器(CharsetDecoder)对象
			CharsetDecoder decoder = charset.newDecoder();
			// 使用解码器将ByteBuffer转换成CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			// CharBuffer的toString方法可以获取对应的字符串
			System.out.println(charBuffer);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
