package com.guchaolong.javalearn.thread.join;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 10:56
 */
public class Test {
    public static void main(String[] args) {

        /**
         * 使用join()方法保证线程执行的顺序
         * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
         */
        Thread t1 = new Thread(()->{
            System.out.println("t1 running");
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();//引用t1线程，等待t1线程执行完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 running");
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();//引用t2线程，等待t1线程执行完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 running");
        });

        t3.start();
        t1.start();
        t2.start();
    }
}
