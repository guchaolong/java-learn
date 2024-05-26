package com.guchaolong.javalearn2.chapter09_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: volatile关键字的使用
 *
 * @author Ezekiel
 * @date 2024/5/24 23:03
 */
public class Code001_Volatile {

    private volatile int inc = 0;
    private AtomicInteger atomicInc = new AtomicInteger(0);

    private void inc() {
        inc++;
    }

    private void atomicInc() {
        atomicInc.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Code001_Volatile instance = new Code001_Volatile();

        // 启动5个线程 ,每个线程执行500次inc()和atomicInc()
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    instance.inc();
                    instance.atomicInc();
                }
            });
        }

        // 等待2秒,保证上面线程执行结束
        Thread.sleep(2000);

        // 正常情况下输出: 2500，但是volatile不能保证原子性，所以每次输出都小于2500
        System.out.println(instance.inc);
        // 因为是AtomicInteger, 保证了原子性，每次输出: 2500
        System.out.println(instance.atomicInc.get());

        // 关闭线程池
        threadPool.shutdown();
    }

}


