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
        byte b = 1;
        short s = b;
        byte b2 = (byte)s;
        short s2 = b;

        char c = (char)b;

        char c2 ='r';
        byte b3 = (byte)c2;

        char c3 = (char)s;

    }
}