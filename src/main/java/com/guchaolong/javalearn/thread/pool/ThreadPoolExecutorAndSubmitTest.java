package com.guchaolong.javalearn.thread.pool;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/28 1:13
 */
public class ThreadPoolExecutorAndSubmitTest {
    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newCachedThreadPool();
        /**
         * executor(）方法只接受RunAble对象
         * submit方法可接受RunAble和CallAble,可以有返回值
         */
        pool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("execute thread: " + i);
                if (i == 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Future<?> submit = pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("submit thread: " + i);
            }
        });
        submit.get();
    }
}
