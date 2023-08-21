package com.guchaolong.javalearn.io1.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/13 18:22
 */
public class Code_05_ClientNIO {
    public static void main(String[] args) {

        try {
            Selector selector = Selector.open();
            SocketChannel client = SocketChannel.open();
            client.configureBlocking(false);
            client.connect(new InetSocketAddress("localhost", 9090));
            client.register(selector, SelectionKey.OP_CONNECT);

            while (true) {
                int select = selector.select();
                if (select == 0) {
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isConnectable()) {
                        handleConnect(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    if (key.isWritable()) {
                        handleWrite(key);
                    }
                    iter.remove();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleConnect(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnectionPending()) {
            channel.finishConnect();
        }
        channel.configureBlocking(false);
        channel.register(key.selector(), SelectionKey.OP_READ);

        sendInfo(channel, "客户端测试!");
    }

    public static void handleRead(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        String msg = "";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                msg += new String(buffer.get(new byte[buffer.limit()]).array());
            }
            buffer.clear();
        }

        System.err.println("收到服务端消息:" + msg);
    }

    public static void handleWrite(SelectionKey key) throws Exception {
        System.err.println("客户端写数据!");
    }

    public static void sendInfo(SocketChannel clientChannel, String msg) throws Exception {
        // 向客户端发送连接成功信息
        clientChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }
}
