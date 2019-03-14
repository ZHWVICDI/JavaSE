package com.qst.chapter01;

import java.nio.CharBuffer;
//Buffer类
public class NIOBufferDemo {

	public static void main(String[] args) {
		// 创建Buffer补充：通过静态方法来获取一个Buffer对象allocate(int capacity)//这里表示创建一个可以容纳8个字符的容器BUffer对象，初始位置：limit==capacity，position==0
		CharBuffer buff = CharBuffer.allocate(8);    // ①
		System.out.println("capacity: "	+ buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// 放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');      // ②
		System.out.println("加入三个元素后，position = "//放入元素后position的位置为3，limit的位置为capacity。结果分析：已读写区域，待读写区域。（其实指的是写入，这里将读写换为写入）
			+ buff.position());
		// 调用flip()方法 	补充：这里将position设置为0，然后limit的位置设置到原position的位置。结果分析：limit和capacity之间的区域不能读写，而我们之前放入元素的区域为未读写区域（这里反转后就是待读入区域，不能读入区域）。
		buff.flip();	  // ③
		System.out.println("执行flip()后，limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// 取出第一个元素
		System.out.println("第一个元素(position=0)：" + buff.get());  // ④
		System.out.println("取出一个元素后，position = "
			+ buff.position());
		// 调用clear方法
		buff.clear();     // ⑤补充：这里position=0，limit=capacity。
		System.out.println("执行clear()后，limit = " + buff.limit());
		System.out.println("执行clear()后，position = "
			+ buff.position());
		System.out.println("执行clear()后，缓冲区内容并没有被清除："
			+ "第三个元素为：" +  buff.get(2));    // ⑥补充：这里根据索引来获取数据，position的值不会被影响。而上面两个都会影响position的值。
		System.out.println("执行绝对读取后，position = "
			+ buff.position());

	}

}
