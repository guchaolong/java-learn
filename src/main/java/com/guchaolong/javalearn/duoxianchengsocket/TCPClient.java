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
package com.guchaolong.javalearn.duoxianchengsocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/23 17:12
 */
public class TCPClient {
    public static void main(String[] args) {

        InetAddress addr = InetAddress.getLoopbackAddress();//localhost/127.0.0.1
        System.out.println(addr);
        try {
            Socket socket = new Socket(addr, 9090);//打开一个远程连接
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            writer.write("tidme\n");
            writer.flush();
            String resp = reader.readLine();
            System.out.println("Response: "+resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}