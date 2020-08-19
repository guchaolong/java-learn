/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/7/13 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.cast;

/**
 *
 */
public class Casting {

    public  Casting(){

    }
    public static void main(String[] args) {
        //把byte类型的赋值给short或char类型
        byte b1 = 1;
        short s1 = b1;
        char c1 = (char)b1;

        //short类型转成byte或char，都需要强转
        short s2 = 1;
        byte b2 = (byte)s2;
        char c2 = (char)s2;

        //char类型转成其他，都需要强转
        char c3 = 'a';
        byte b3 = (byte)c3;
        short s3 = (short)c3;

        //总结，byte-short-int-long-float-double遵循规则，有char都必须强转

    }
}