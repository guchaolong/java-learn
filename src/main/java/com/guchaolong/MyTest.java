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
                System.out.println("thread: " + i);
            }
        });


        Future<?> submit = pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("thread: " + i);
            }
        });
        submit.get();

        System.out.println(((1<3)?"a":"b")+3+4);
        System.out.println(((1<3)?"a":"b")+(3+4));


    }
}
