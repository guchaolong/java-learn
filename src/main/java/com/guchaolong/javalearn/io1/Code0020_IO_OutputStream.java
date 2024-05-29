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

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/19 2:24
 */
public class Code0020_IO_OutputStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("./output.txt");
            byte[] b = "hello sb assda".getBytes("UTF-8");
            fos.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}