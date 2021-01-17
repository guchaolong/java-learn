package com.guchaolong.javalearn.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/19 14:22
 */
public class Test1 {

    private final static String ss = "finalParam";

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();


        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 36000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024));
        for (int i = 0; i < 30; i++) {
            System.out.println("i : " + i);
            pool.execute(() -> System.out.println(Thread.currentThread().getName()));
            System.out.println("getPoolSize " + pool.getPoolSize());
        }


        System.out.println(1234343556 % 16);
        System.out.println(1234343556 & (16 - 1));

//        Scanner S = new Scanner(System.in);
//        int i = S.nextInt();
//        System.out.println(i);
//        String scannerString = S.nextLine();
//        System.out.println("fgd"+ scannerString);
//
//        System.out.println("---------------------");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        System.out.println(s);

        String a = finallyTest1();
        System.out.println(a);

        StringBuffer sb = new StringBuffer("ds");

        System.out.println(2 << 2);
        System.out.println(2 << 24);
        System.out.println(33554432 / 8 / 1024);
        //数组定义
        int[] arr1 = new int[3];

        int[] arr2 = new int[]{1, 2, 3};

        int[] arr3 = {1, 2, 3};


        //new一个对象过程
        SunNewClass sunNewClass = new SunNewClass();
        System.out.println("===============================");

        //创建对象的几种方法
        //1 new
        FatherNewClass f = new FatherNewClass();
        System.out.println("===============================");

        //2 反射 Class的newInstance
        Class clasz = Class.forName("com.guchaolong.javalearn.base.FatherNewClass");
        FatherNewClass o = (FatherNewClass) clasz.newInstance();

        //构造函数的newInstance
//        Constructor<FatherNewClass> constructor = FatherNewClass.class.getConstructor();
//        FatherNewClass fatherNewClass = constructor.newInstance();


    }

    public static String finallyTest1() {
        String a = "aaaa";
        try {
            return a;
        } finally {
            a = "bbbb";
        }


    }
}
