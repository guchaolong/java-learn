package com.guchaolong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/28 1:13
 */
public class MyTest {
    public static void main(String[] args) throws Exception{
        boolean b = true;

        //switch : 没有boolean float double long  
        // char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'


        /**
         * hashCode
         */
        ExecutorService pool = Executors.newCachedThreadPool();

        /**
         * executor方法只接受RunAble对象
         * submit方法可接受RunAble和CallAble,可以有返回值
         */
        pool.execute(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("execute thread: " + i);
                if(i == 5){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Future<?> submit = pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("submit thread: " + i);
            }
        });
        submit.get();



    }
}
