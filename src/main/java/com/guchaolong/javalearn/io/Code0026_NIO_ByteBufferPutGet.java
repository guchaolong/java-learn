package com.guchaolong.javalearn.io;

import java.nio.ByteBuffer;

/**
 * yteBuffer 支持类型化的 put 和 get，
 * put 放入的是什么数据类型，get 就应该使用相应的数据类型来取出，
 * 否则可能有 BufferUnderflowException 异常
 * @author ezekiel
 */
public class Code0026_NIO_ByteBufferPutGet {
    public static void main(String[] args) {

        //创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();

        System.out.println();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
