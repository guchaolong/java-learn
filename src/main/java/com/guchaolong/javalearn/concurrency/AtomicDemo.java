package com.guchaolong.javalearn.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/11 18:07
 */
public class AtomicDemo {


    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.getAndIncrement();
        ai.incrementAndGet();

    }
}
