/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/28 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.ThreadTest;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 0:51
 */
public class MyRunnable implements Runnable {
    private Thread thread;
    private String threadName;

    MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {

        System.out.println("进入线程的run方法了");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + "--" + i);
                Thread.sleep(5000L);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName+"interrupted");
        }
        System.out.println(String.format("线程%s要退出了", threadName));
    }

    void start(){
        if(thread == null){
            thread = new Thread(this);
        }
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}