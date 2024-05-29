package com.guchaolong.javalearn.io2;

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

/**
 * 非阻塞IO
 * 服务端：ServerSocketChannel
 * 客户端：SocketChannel
 * <p>
 * 它的accept()和read()方法是会立即返回的，不需要等待，可以根据这个返回结果做相应的处理，
 * 但是需要不断的轮询，也就是死循环调这两个方法，轮询内核
 *
 * @author ezekiel
 */
public class Code0031_NIO_ServerSocketChannel {

    public static void main(String[] args) throws Exception {
        List<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));

        //重点  对应到内核 NONBLOCKING
        ss.configureBlocking(false);

        //整个主线程一直在轮询，但是这里是用户线程主动去轮询内核
        while (true) {
            Thread.sleep(1000);

            //这里不会阻塞，因为会返回一个结果，后续做相应处理,
            //调用内核了
            //1. 如果没有客户端连进来 返回值？ BIO的时候会一直等着，不会有返回，配置了Nonblocking, NIO,会返回-1（或者null）
            //2. 有客户端连进来，就能接受的客户端，对应到内核中就是一个fd (文件描述符）
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
