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
package com.guchaolong.javalearn.socket;

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
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Tcp server ready");
            Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            String cmd = reader.readLine();
            if("time".equals(cmd)){
                writer.write(LocalDateTime.now().toString()+"\n");
                writer.flush();
            }else{
                writer.write("sorry?\n");
                writer.flush();
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}