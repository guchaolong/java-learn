package com.guchaolong.javalearn.thread.countdownlaunch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/21 18:30
 */
public class CountDownLatchTest {
    public static void main(String[] args){
        CountDownLatch count = new CountDownLatch(2);
        System.out.println("zhu xian cheng 1");

        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        pool1.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub thread1" + Thread.currentThread().getName() + "starting");
            count.countDown();
        });
        pool1.shutdown();

        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        pool2.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub thread2" + Thread.currentThread().getName() + "starting");
            count.countDown();
        });
        pool2.shutdown();

        System.out.println("zhu xian cheng 2");

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //因为前面有await方法，位于主线程中，所以主线程中位于await后的内容要等count为0时才能继续执行
        System.out.println("zhu xian cheng 3");
    }
}
