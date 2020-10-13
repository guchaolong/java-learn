package com.guchaolong.javalearn.io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/9 2:57
 */
public class ChannelTest {
    public static void main(String[] args) throws Exception{

        //获取通道
        //1 本地io
        FileInputStream fis = new FileInputStream("E:\\project\\java-learn\\input_NIO.txt");
        FileChannel in = fis.getChannel();

        //2 open
        FileChannel out = FileChannel.open(Paths.get("E:\\project\\java-learn\\output_NIO.txt"), StandardOpenOption.WRITE);

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //TODO 将通道内的(所有）数据一次性写入缓冲区?
        while (in.read(buf) != -1){
            //切换到读取数据模式
            buf.flip();
            out.write(buf);
            buf.clear();
        }

    }
}
