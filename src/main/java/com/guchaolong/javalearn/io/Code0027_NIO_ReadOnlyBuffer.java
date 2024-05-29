package com.guchaolong.javalearn.io;

import java.nio.ByteBuffer;

/**
 * @author ezekiel
 * 可将一个普通Buffer转换为只读Buffer，只读Buffer只能读取数据，不能修改数据。
 * 调用asReadOnlyBuffer()方法可以将一个普通Buffer转换为只读Buffer。
 */
public class Code0027_NIO_ReadOnlyBuffer {
    public static void main(String[] args) {

        //创建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }

        //读取
        buffer.flip();

        //得到一个只读的Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        //读取
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 100); //ReadOnlyBufferException
    }
}
