/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/6 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.reenternlock;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/6 23:05
 */
public class ServiceA {
    private ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public synchronized void test1(){
        System.out.println("当前线程"+Thread.currentThread().getName()+"占用锁");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2(){
        System.out.println("另一个线程调用test2(),需要获取锁");
        synchronized (this){
            System.out.println("当前线程"+Thread.currentThread().getName()+"占用锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void f1() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            condition.await();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}