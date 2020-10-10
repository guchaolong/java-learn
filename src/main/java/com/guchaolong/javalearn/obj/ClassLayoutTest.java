package com.guchaolong.javalearn.obj;


import org.openjdk.jol.info.ClassLayout;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/10 21:49
 */
public class ClassLayoutTest {
    public static void main(String[] args) {
        /*
        mark word 占8个字节（前两个object header)
        class pointer 默认开启压缩，占4个字节 ，否则占8个字节（第三个header)
        对于数组，有低四个header  占4个字节
         */
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("====================================");

        int[] arr = new int[4];
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());

    }
}
