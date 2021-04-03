package com.guchaolong.javalearn.io2.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/4/1 1:17
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true){
            System.out.println("server already, waiting accept...");
            Socket client = server.accept();

            System.out.println("有客户端连接进来了...客户端port: " + client.getPort() + "等待客户端发送数据");

            byte[] buff = new byte[1024];
            int read = client.getInputStream().read(buff);
            if(read != -1){
                System.out.println("接受到的客户端发送的数据" + new String(buff, 0, read));
            }
        }
    }

    //打开cmd       telnet localhost 9000   就能启动一个client 连接到这个server
}
