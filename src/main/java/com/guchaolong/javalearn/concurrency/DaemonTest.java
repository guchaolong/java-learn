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

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 15:52
 */
public class DaemonTest {
    public static void main(String[] args) {
        /**
         * main是非守护线程
         *
         * 当JVM中已经没有非守护线程，那么所有的守护线程也需要立即终止，所有守护线程中finally中的代码不一定能执行
         */
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();

    }
    static class DaemonThread implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("守护线程的finally（不一定执行）");
            }
        }
    }
}