package com.guchaolong.javalearn.thread.volati;

import javax.sql.XAConnection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/24 21:21
 */
public class VolatileTest {

    private volatile int inc = 0;

    private AtomicInteger integer = new AtomicInteger(0);

    public void inc() {
        inc++;
    }

    public void incInteger(){
        integer.incrementAndGet();
    }
    public static void main(String[] args) {

        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    test.inc();
                    test.incInteger();
                }
            }).start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(test.inc);
        System.out.println(test.integer);

    }
}
