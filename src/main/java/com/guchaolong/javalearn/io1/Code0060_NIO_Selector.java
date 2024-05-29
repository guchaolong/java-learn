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
 * Description: Code0050中的问题，需要不断的轮询，效率低下
 * 因此可以使用Selector来处理事件，Selector会将注册在其上的Channel的事件通知给注册在其上的Selector，
 * 从而避免了轮询，提高了效率。
 *
 * @author Ezekiel
 * @date 2024/5/29 07:06
 */
public class Code0060_NIO_Selector {
    public static void main(String[] args) throws IOException {

        //创建NIO ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));

        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //打开Selector处理Channel,即创建epoll
        Selector selector = Selector.open();
        //将ServerSocketChannel注册到Selector上，并且selector对客户端的accept连接事件感兴趣
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");

        while (true) {
            //阻塞等待需要处理的事件发生
            selector.select();

            //获取selector中注册的已经准备好的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            //遍历selectionKeys对事件进行处理
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //如果是OP_ACCEPT事件，则处理连接accept和事件注册
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //接受客户端连接请求
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    //这里只注册了OP_READ事件，即只监听读事件，如果需要给客户端发送数据，则注册OP_WRITE事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                } else if (key.isReadable()) {//如果是OP_READ事件，则处理读取和打印
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                    int len = socketChannel.read(byteBuffer);
                    //如果有数据，则读取数据并打印
                    if (len > 0) {
                        System.out.println("接收到消息" + new String(byteBuffer.array()));
                    } else if (len == -1) {//如果客户端断开连接，则关闭SocketChannel
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                }
                //从事件集合里删除本次处理的key，防止下次重复处理
                iterator.remove();
            }
        }
    }
}
