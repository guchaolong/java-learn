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
package com.guchaolong.javalearn.thread.thread.callable;

import com.guchaolong.javalearn.thread.thread.callable.CallableTest;

import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 1:33
 */
public class Main {
    public static void main(String[] args) throws Exception{

        //CallableTest实现Callable接口
        //用FutureTask包装
        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
        //FutureTask实例作为Thread参数
        new Thread(futureTask).start();
        FutureTask<String> futureTask2 = new FutureTask<>(new CallableTest());
        new Thread(futureTask2).start();
        String s = futureTask.get();
        System.out.println(s);
    }
}