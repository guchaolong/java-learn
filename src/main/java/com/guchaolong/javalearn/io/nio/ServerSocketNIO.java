package com.guchaolong.javalearn.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/13 14:16
 */
public class ServerSocketNIO {

    public static void main(String[] args) throws Exception {


        List<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));

        //重点
        ss.configureBlocking(false);

        //整个主线程一直在轮询，但是这里是用户线程主动去轮询内核
        while (true) {
            Thread.sleep(1000);

            //这里不会阻塞，因为会返回一个结果，后续做相应处理,
            SocketChannel client = ss.accept();
            if (client == null) {
                System.out.println("null...");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client port: " + port);
                clients.add(client);
            }

            /*
            分配缓冲区 （这个缓冲区可以在堆里，也可以在堆外）
             */
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

            for (SocketChannel c : clients) {//串行化
                int num = c.read(buffer);// >0 -1 0  能得到一个结果，后续做相应的处理，所以这里也不会阻塞
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + " : " + b);
                    buffer.clear();
                }
            }
        }
    }
}
