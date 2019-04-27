/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/28 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.ThreadTest;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 0:59
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("当前的线程--"+Thread.currentThread());
        MyRunnable myRunnable = new MyRunnable("fuck");

        myRunnable.start();
        System.out.println("草泥马，你跑你的，我是主线程");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("草泥马，你跑你的，我是主线程");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}