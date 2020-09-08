package com.guchaolong.javalearn.io_nio;

import java.nio.ByteBuffer;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/9 2:33
 */
public class NIOBufferTest {
    public static void main(String[] args) {
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //初始状态
        System.out.println("初始时-->容量capacity：" + byteBuffer.capacity());
        System.out.println("初始时-->可操作数据的大小limit：" + byteBuffer.limit());
        System.out.println("初始时-->位置position：" + byteBuffer.position());
        System.out.println("初始时-->标记mark：" + byteBuffer.mark());
        System.out.println("===================================================");

        //添加
        byteBuffer.put("Java3y".getBytes());
        System.out.println("put完之后-->容量capacity：" + byteBuffer.capacity());
        System.out.println("put完之后-->可操作数据的大小limit：" + byteBuffer.limit());
        System.out.println("put完之后-->位置position：" + byteBuffer.position());
        System.out.println("put完之后-->标记mark：" + byteBuffer.mark());
        System.out.println("===================================================");

        //flip切换成读模式
        byteBuffer.flip();
        System.out.println("flip完之后-->容量capacity：" + byteBuffer.capacity());
        System.out.println("flip完之后-->可操作数据的大小limit：" + byteBuffer.limit());
        System.out.println("flip完之后-->位置position：" + byteBuffer.position());
        System.out.println("flip完之后-->标记mark：" + byteBuffer.mark());
        System.out.println("===================================================");

        //取数
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println("取数结果" + new String(bytes));

    }
}
