package com.guchaolong.javalearn2.concurrent;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/8/8 17:12
 */
public class Code_001_Thread {
    public static void main(String[] args) throws InterruptedException {

        //
        Thread t = new Thread(() -> {
            System.out.println("thread running");
            System.out.println(Thread.currentThread().getState());//RUNNABLE
        });

        System.out.println(t.getState());//NEW

        t.start();
        //t.start(); //start方法不能多次调用
        System.out.println(t.getState());//RUNNABLE

        Thread.sleep(2000);
        System.out.println(t.getState());//TERMINATED


    }
}
