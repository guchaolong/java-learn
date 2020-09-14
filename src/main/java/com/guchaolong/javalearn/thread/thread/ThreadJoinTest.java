package com.guchaolong.javalearn.thread.thread;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/9 11:51
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1线程");
        });


        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2线程");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3线程");
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
