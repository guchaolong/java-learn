package com.guchaolong.javalearn.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 多线程版多路复用
 *
 * @author AA
 * @date 2020/10/13 17:15
 */
public class SocketMultiplexingThreadV2 {

    /*
    NIO

    nonblocking: socket网络，内核机制
    new  : jdk {channel, buffer, select(多路复用器）}

     */

    private ServerSocketChannel server = null;
    private Selector selector1 = null;
    private Selector selector2 = null;
    private Selector selector3 = null;
    int port = 9090;


    public static void main(String[] args) {
        SocketMultiplexingThreadV2 service = new SocketMultiplexingThreadV2();
        service.initServer();

        NioThread t1 = new NioThread(service.selector1, 2);
        NioThread t2 = new NioThread(service.selector2);
        NioThread t3 = new NioThread(service.selector3);


        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();

        System.out.println("服务器启动了。。。");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector1 = Selector.open();
            selector2 = Selector.open();
            selector3 = Selector.open();


            /*
            FIXME 我的理解： 把serverChannel的可ACCEPT事件注册到多路复用器上

            这样的就不用主动轮询内核是否有连接可以accept，
            把这个事情交给多路复用器去完成
             */
            //只在selector1上注册
            server.register(selector1, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class NioThread extends Thread {
    Selector selector = null;
    static int selectors = 0; //worker的数量
    int id = 0;
    boolean isBoss = false;

    //注意，是static的，所以boss workerd都能访问到
    static BlockingQueue<SocketChannel>[] queue;
    static AtomicInteger idx = new AtomicInteger();

    //给Boss用的构造器
    NioThread(Selector selector, int n) {
        this.selector = selector;
        selectors = n;
        isBoss = true;

        queue = new LinkedBlockingQueue[selectors];

        for (int i = 0; i < n; i++) {
            queue[i] = new LinkedBlockingQueue<>();
        }
        System.out.println("Boss启动");
    }

    //给worker用到构造器
    NioThread(Selector sel) {
        this.selector = sel;
        id = idx.getAndIncrement() % selectors;
        System.out.println("worker " + id + "启动");
    }

    @Override
    public void run() {
        try {
            while (true) {
                while (selector.select(10) > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        }
                    }
                }

                //boss不参与  只有worker根据分配，分别注册自己的client
                if (!isBoss && !queue[id].isEmpty()) {
                    ByteBuffer buffer = ByteBuffer.allocate(8192);
                    SocketChannel client = queue[id].take();
                    client.register(selector, SelectionKey.OP_READ, buffer);
                    System.out.println("===================================================");
                    System.out.println("新客户端：" + client.socket().getPort() + "分配到worker: " + id);
                    System.out.println("===================================================");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);

            int num = idx.getAndIncrement() % selectors;//0 1
            queue[num].add(client);
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
                //把客户端里的数据读到buffer里
                read = client.read(buffer);
                if (read > 0) {
                    buffer.flip();
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