package com.guchaolong.javalearn.thread.reenternlock3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/20 2:48
 */
public class Ticket implements Runnable {
    private int ticket = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {   // 重写run方法
        while (true) {
            lock.lock();  //调用Lock接口方法lock获取锁
            try {
                if (ticket > 0) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " chu shou le yi zhang che piao , sheng yu" + --ticket + "zhang");
                }
            } catch (Exception ex) {

            } finally {
                lock.unlock();  //释放锁,调用Lock接口方法unlock
            }

        }
    }

}
