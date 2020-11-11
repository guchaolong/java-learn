package com.guchaolong.javalearn.threadlocal;

import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/6 4:02
 */
public class ThreadLocalTest2 {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        IntStream.range(0,3).forEach(a->{
            new Thread(()->{
                local.set(a + "-");
                System.out.println("线程" + a + " 变量为 " + local.get());
            }).start();
        });
    }
}
