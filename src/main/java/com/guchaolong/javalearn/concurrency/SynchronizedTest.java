package com.guchaolong.javalearn.concurrency;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/11 2:48
 */
public class SynchronizedTest {
    public static void main(String[] args) {

        /*
        锁消除

        append()是synchronized修饰的，但是sb这个引用不可能在其他线程里用到
        不可能是共享资源
        jvm会自动取消sb内部的锁

         */
        StringBuffer sb = new StringBuffer();
        sb.append("sdf").append("sdf");


    }
}
