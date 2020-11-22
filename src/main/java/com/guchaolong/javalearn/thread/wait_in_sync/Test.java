package com.guchaolong.javalearn.thread.wait_in_sync;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 10:35
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        obj.wait();//wait notify方法只能在同步代码块中使用，否则抛出IllegalMonitorStateException异常
    }
}
