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
package com.guchaolong.javalearn.chapter05Collection;

import java.io.*;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/19 2:51
 */
public class SerialiableTest {
    public static void main(String[] args) {
        String str = "save.data";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            outputStream.write(999);
            outputStream.writeUTF("hello,word");
            outputStream.writeObject(new Person(12,"xiaomin"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(str)));
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readUTF());
            Person p = (Person)inputStream.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}