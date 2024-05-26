package com.guchaolong.javalearn.thread.pool;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/7 0:03
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS,
                queue);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

    }
}
