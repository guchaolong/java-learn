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

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 15:05
 */
public class ThreadState {
    public static void main(String[] args) {

        new Thread(new Waiting(),"waitingThread").start();
        new Thread(new TimeWaiting(),"TimeWaiting").start();
        new Thread(new Blocked(),"Blocked1").start();
        new Thread(new Blocked(),"Blocked2").start();

        /**
         * cmd -> jps ->jstack 1234查看ThreadState进程的线程信息
         */
    }

    /**
     * 这个线程获取到Waiting.class锁之后，又释放，并且在Waiting.class上等待
     */
    static class Waiting implements Runnable{
        @Override
        public void run() {
            synchronized (Waiting.class){
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 这个线程会不断的进行休眠
     */
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 这个线程获取Blocked锁后，一直休眠，不会释放锁
     */
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}