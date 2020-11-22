package com.guchaolong.javalearn.thread.create_thread;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 9:51
 */
public class ByThread extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread类的线程 " + Thread.currentThread().getName() + "，运行中...");
    }
}
