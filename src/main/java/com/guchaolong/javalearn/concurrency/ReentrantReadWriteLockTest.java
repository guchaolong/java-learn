/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/7 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 18:09
 */
public class ReentrantReadWriteLockTest {

    static class MyCache {
        private Map<String, String> map = new HashMap<>();

        //读写锁
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //多个线程可以共享读锁，阻止写锁
        private Lock readLock = lock.readLock();
        //独占锁，只能有一个线程占用，其他线程对读锁和写锁的获取都会被阻塞
        private Lock writeLock = lock.writeLock();

        public void read(String s) {
            readLock.lock();
            try {
                System.out.println("读线程：" + Thread.currentThread().getName() + (map.containsKey(s) ? map.get(s) : "?"));
            } catch (Exception e) {

            } finally {
                readLock.unlock();
            }
        }

        public void write(String key, String value) {
            writeLock.lock();
            try {
                map.put(key, value);
                System.out.println("写线程：" + Thread.currentThread().getName());
            } finally {
                writeLock.unlock();
            }
        }


    }

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        new Thread(() -> myCache.read("q"), "read").start();
        new Thread(() -> myCache.write("q", "qqq"), "write").start();
    }
}