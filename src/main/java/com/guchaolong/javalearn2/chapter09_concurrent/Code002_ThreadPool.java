package com.guchaolong.javalearn2.chapter09_concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2024/5/26 03:04
 */
public class Code002_ThreadPool {
    private static final Logger logger = LoggerFactory.getLogger(Code002_ThreadPool.class);

    public static void main(String[] args) {


        // 创建一个线程工厂，为线程命名
        ThreadFactory myThreadFactory = new NamingThreadFactory("my-thread-");


        // 创建一个线程池，核心线程数为1，最大线程数为2，
        // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间为60秒，
        //任务队列为容量为1的ArrayBlockingQueue，饱和策略为CallerRunsPolicy。
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,
                2,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                myThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());


        //提交第一个任务，由于线程池中只有一个核心线程，所以该任务会被立即执行。
        threadPool.execute(() -> {
            logger.info("核心线程执行第一个任务,1分钟后完成");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //提交第二个任务，由于核心线程被占用，任务将进入队列等待
        threadPool.execute(() -> {
            logger.info("非核心线程处理入队的第二个任务，1分钟后完成");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //提交第三个任务，由于核心线程被占用且队列已满，创建非核心线程处理
        threadPool.execute(() -> {
            logger.info("非核心线程处理队列满的第三个任务，1分钟后完成");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 提交第四个任务，由于核心线程和非核心线程都被占用，队列也满了，根据CallerRunsPolicy策略，
        // 任务将由提交任务的线程（即主线程）来执行
        threadPool.execute(() -> {
            logger.info("主线程处理第四个任务，2分钟后完成");
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 提交第五个任务，主线程被第四个任务卡住（第四个任务用时2分钟），该任务必须等到主线程执行完才能提交
        threadPool.execute(() -> {
            logger.info("核心线程执行第五个任务");
        });

        // 关闭线程池
        threadPool.shutdown();
    }
}

class NamingThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final String namePrefix;

    public NamingThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(namePrefix + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}