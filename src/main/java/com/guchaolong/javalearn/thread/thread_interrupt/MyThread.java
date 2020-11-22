package com.guchaolong.javalearn.thread.thread_interrupt;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 10:15
 */
public class MyThread extends Thread {
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop){
            System.out.println(getName() + " is running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("week up from block... ");
                stop = true;
            }
        }
        System.out.println(getName() + " is exiting...");
    }
}
