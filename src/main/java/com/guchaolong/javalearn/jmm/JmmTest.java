/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/8/31 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.jmm;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 *
 */
public class JmmTest {
    private static  boolean initFlag = false;
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("waiting1...");
            while (!initFlag) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("========success======");
        }).start();



        new Thread(() -> {
            System.out.println("preparing data...");
            initFlag = true;
            System.out.println("data already prepared");
        }).start();
    }
}