package com.guchaolong.javalearn.io2.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * 单线程版
 * 因为有两处阻塞，所以如果有一个连接进来了，但是这个链接没有数据输入，那么就只能等，这个时候是处理不了其他连接的
 * 改进：多线程，有链接进来的时候，开启新的线程处理该链接，见Code_02_BIOServer
 *
 * @author GUCHAOLONG
 * @date 2021/4/1 1:17
 */
public class Code_01_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true){
            System.out.println("server already, waiting accept...");
            //阻塞1，如果没有客户端连接进来，client就不会有返回，就会一直等待，下面的代码就不会执行
            Socket client = server.accept();

            System.out.println("有客户端连接进来了...客户端port: " + client.getPort() + "等待客户端发送数据");

            byte[] buff = new byte[1024];

            //阻塞2，read是阻塞方法，如果客户端没有输入，read就不会有返回，就会一直等待，下面的代码不会执行
            int read = client.getInputStream().read(buff);
            if(read != -1){
                System.out.println("接受到的客户端发送的数据" + new String(buff, 0, read));
            }
        }
    }

    //打开cmd       telnet localhost 9000   就能启动一个client 连接到这个server
}
