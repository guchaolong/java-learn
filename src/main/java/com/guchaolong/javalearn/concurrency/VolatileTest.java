package com.guchaolong.javalearn.concurrency;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/25 21:35
 */
public class VolatileTest {
//    private static volatile boolean flag = true;
    private static boolean flag = true;
    public static void main(String[] args) throws Exception{

        new Thread(()->{
            while(flag){
            }
            System.out.println("end");
        },"server").start();

        Thread.sleep(1000);
        flag = false;
    }
}
