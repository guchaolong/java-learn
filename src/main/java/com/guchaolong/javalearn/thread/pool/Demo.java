package com.guchaolong.javalearn.thread.pool;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/7 0:03
 */
public class Demo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS,
                queue);
    }
}
