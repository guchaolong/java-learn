package com.guchaolong.javalearn.threadlocal;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/24 16:32
 */
public class ThereadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello");
        threadLocal.set("world");
        System.out.println("main线程get：" + threadLocal.get());
        threadLocal.remove();
        System.out.println("main线程get：" + threadLocal.get());

        new Thread(() -> {
            System.out.println("other 线程get" + threadLocal.get());
        }).start();
    }
}
