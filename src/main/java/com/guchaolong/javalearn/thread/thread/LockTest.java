/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: design-pattern
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/4/27 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/4/27 1:28
 */


public class LockTest {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.add(1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.dec(1);
            }
        });
        t1.start();
        t2.start();
        System.out.println(counter.getValue());
    }

}

class Counter {
    private int value = 0;
    private Lock lock = new ReentrantLock();

    public void add(int m) {
        lock.lock();
        try {
            value += m;
            Thread.sleep(1000);
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }

    }

    public void dec(int m) {
        lock.lock();
        try {
            value = value - m;
            Thread.sleep(1000);
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }

    }

    public int getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}