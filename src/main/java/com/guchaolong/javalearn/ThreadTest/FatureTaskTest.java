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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 1:51
 */
public class FatureTaskTest implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FatureTaskTest call = new FatureTaskTest();
        FutureTask<Integer> ft = new FutureTask<>(call);
        Thread t = new Thread(ft);
        t.start();
        for (int i = 0; i<100; i++){
            System.out.println("主线程执行第"+i+"次");
            if(i==20){
                Integer result = ft.get();
                System.out.println("DSDSFSDFSDFS------------"+result);
            }
        }


    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            if(i>50)
                Thread.sleep(5000);
            System.out.println("第" + i + "次");
        }
        return i;

    }
}