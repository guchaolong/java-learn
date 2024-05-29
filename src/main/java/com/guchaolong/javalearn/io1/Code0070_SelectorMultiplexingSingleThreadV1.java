package com.guchaolong.javalearn.io1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: 单线程版多路复用
 *
 *
 * 单线程版非阻塞IO：需要用户线程主动轮询内核，是否有数据
 * 在Channel的基础上，有引入了Selector(多路复用器）
 * Channel可以把自己注册到Selector上，把这个轮询的过程交给内核的selector去做，我们循环的轮询Selector就行
 * selector.select（）可以知道是否有事件到达
 * @author ezekiel
 */
public class Code0070_SelectorMultiplexingSingleThreadV1 {

    /*
    NIO

    nonblocking: socket网络，内核机制
    new  : jdk {channel, buffer, select(多路复用器）}

     */

    private ServerSocketChannel server = null;
    private Selector selector = null;

    int port = 9090;

    public static void main(String[] args) {
        Code0070_SelectorMultiplexingSingleThreadV1 service = new Code0070_SelectorMultiplexingSingleThreadV1();
        service.start();
    }

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector = Selector.open();


            /*
            FIXME 我的理解： 把serverSocketChannel的可ACCEPT事件注册到多路复用器上

            这样的就不用主动轮询内核是否有连接可以accept，
            把这个事情交给多路复用器去完成
             */
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {

        initServer();
        System.out.println("服务器启动了..................");

        //死循环
        while (true) {
            try {
                //问下内核，是否有事件到达
                while (selector.select(0) > 0) {

                    //从多路复用器，取出有效的key
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();

                        //是否可以建立连接
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {//是否可以读数据
                            System.out.println("一般由用户数据到达会触发，但啥时候会疯狂触发呢");
                            readHandler(key);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);
            //针对每个客户端都新建一个buffer
            ByteBuffer buffer = ByteBuffer.allocate(8192);

            //把客户端channel，的可读事件，连同buffer,注册到多路复用器,如果客户端写入数据，那server就可以来读取了
            client.register(selector, SelectionKey.OP_READ, buffer);

            System.out.println("==========================================================================================");
            System.out.println("新客户端：" + client.getRemoteAddress());
            System.out.println("此时的select：" + selector);
            System.out.println("此时的ssc：" + ssc);
            System.out.println("此时的client：" + client);
            System.out.println("此时的buffer：" + buffer);
            System.out.println("==========================================================================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        //先清空buffer
        buffer.clear();

        int read = 0;
        try {
            while (true) {
                System.out.println("buffer1: " + buffer.mark());
                //把客户端里的数据读到buffer里
                read = client.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    System.out.println("get" + buffer.get());
                    System.out.println("buffer2: " + buffer.mark());
                    System.out.println("buffer3: " + buffer.mark());
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (read == 0) {
                    break;
                } else {//-1  客户端出现close_wait  bug  死循环  CPU100%
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

