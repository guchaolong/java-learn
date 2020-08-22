package com.guchaolong.javalearn.thread.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/22 16:27
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        //信号量，只允许3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            final long num = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();

                        System.out.println("Accessing" + num);

                        Thread.sleep(new Random().nextInt(5000));

                        semaphore.release();
                        System.out.println("Release" + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        pool.shutdown();
    }
}
