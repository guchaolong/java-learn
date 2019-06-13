/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/7 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.concurrency;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 11:28
 */
public class DeadLockDemo {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (object1){
                System.out.println("线程1获取到object1的锁");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("线程1获取到object2的锁");
                }
            }

        }).start();
        new Thread(()->{
            synchronized (object2){
                System.out.println("线程2获取到object2的锁");
                synchronized (object1){
                    System.out.println("线程2获取到object1的锁");
                }
            }

        }).start();
    }

}