package com.guchaolong.javalearn.thread.reenternlock2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/20 2:14
 */
public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final int[] item = new int[10];

    int putptr, takeptr, count;

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {
            while (count == item.length) {
                notFull.await();
            }
            item[putptr] = x;
            if (++putptr == item.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }



    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            int x = item[takeptr];
            if (++takeptr == item.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
