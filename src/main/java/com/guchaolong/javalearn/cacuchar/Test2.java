/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/9/7 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.cacuchar;

/**
 *
 */
public class Test2 {
    public static void main(String[] args) {
        //左移n位 乘以2的n次方
        System.out.println(2<<3);//16
        System.out.println(32>>3);//4
        System.out.println(24>>>3);//3
        System.out.println(-24>>>3);//536870909
        System.out.println(24>>>-3);//
        System.out.println(-24>>>-3);//


        int a = 1;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a :" + a);
        System.out.println("b :" + b);

        int c = 1;
        int d = 2;
        c = c ^ d;
        d = c ^ d;
        c = c ^ d;
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }
}