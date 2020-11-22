package com.guchaolong.javalearn.thread.create_thread;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 9:52
 */
public class ByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("通过实现Runnable的线程"  + Thread.currentThread().getName() + "，运行中...");
    }
}
