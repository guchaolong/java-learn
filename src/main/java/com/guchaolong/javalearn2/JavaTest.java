/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/27 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn2;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/27 0:50
 */
public class JavaTest {
    public static void main(String[] args) {
        String str = "\\\\ssgfsd";
        System.out.println(str.intern());
        int a = 1;
        System.out.println(++a);
        System.out.println(a);
        System.out.println(Byte.SIZE+" "+Byte.MIN_VALUE);
    }
}