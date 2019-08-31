/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/9/1 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.jmm;

/**
 *
 */
public class DeadWhileTest {
    public static void main(String[] args) {
        boolean a = true;

        while (a){
//            System.out.println("sdg");
        }

        System.out.println("dsg");
    }
}