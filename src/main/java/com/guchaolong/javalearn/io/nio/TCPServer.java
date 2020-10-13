/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/23 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.io.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/23 17:13
 */
public class TCPServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9091);
            System.out.println("Tcp server ready");

            //阻塞1，等待客户端来连接,如果没有客户端连接过来，则一直等待在这，下面的代码不会执行
            //也就是说如果没有accept到，就不会返回这个client
            Socket client = serverSocket.accept();

            System.out.println(client.getPort());

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8));

            //阻塞2，等待输入，如果有客户端连接进来了，但是没有传过来数据，也会一直等待在这
            //也就是说如果没有读取到，就不会返回这个cmd
            String cmd = reader.readLine();

            if ("time".equals(cmd)) {
                writer.write(LocalDateTime.now().toString() + "\n");
                writer.flush();
            } else {
                writer.write("sorry?\n");
                writer.flush();
            }

            client.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}