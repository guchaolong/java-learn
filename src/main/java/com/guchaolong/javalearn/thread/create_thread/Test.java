package com.guchaolong.javalearn.thread.create_thread;

import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 9:53
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ByThread t1 = new ByThread();
        t1.start();

        ByRunnable r = new ByRunnable();
        Thread t = new Thread(r);
        t.start();

        ByCallable c = new ByCallable();
        FutureTask<String> futureTask = new FutureTask<String>(c);
        Thread t2 = new Thread(futureTask);
        t2.start();
        System.out.println("futureTask:" + futureTask.get());

    }
}
