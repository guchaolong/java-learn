/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/19 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/19 1:41
 */
public class Code0010_IO_InputStream {
    public static void main(String[] args) {
        int a = '您';
        System.out.println(a);
        FileInputStream inputStream = null;
        try {
            File file = new File("input.txt");
            file.createNewFile();
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1000];
            int n = 0;
            while ((n = inputStream.read(buffer)) != -1) {
                System.out.println("读取了" + n + "个字节");
                System.out.println(new String(buffer));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}