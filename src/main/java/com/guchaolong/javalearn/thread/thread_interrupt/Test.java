package com.guchaolong.javalearn.thread.thread_interrupt;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 10:14
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Thread.sleep(3000);
        System.out.println("interrupt thread..." + t.getName());
        t.stop = true;
        t.interrupt();
        Thread.sleep(3000);
    }
}
