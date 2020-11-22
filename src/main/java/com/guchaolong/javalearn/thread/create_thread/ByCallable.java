package com.guchaolong.javalearn.thread.create_thread;

import java.util.concurrent.Callable;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/22 9:57
 */
public class ByCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("通过实现Callable的线程" + Thread.currentThread().getName() +"，运行中...");
        return "hello";
    }
}
