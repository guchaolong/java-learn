package com.guchaolong.javalearn.thread.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/9 10:55
 */
public class CreateThread {
    public static void main(String[] args) {
        //1
        MyTest t = new MyTest();
        t.run();
        System.out.println("WORLD");
        //
        new Thread(()-> System.out.println("WORLD")).start();

        //2
        Thread t2 = new Thread(new MyThread());
        t2.start();

        //3
        MyCallAble callAble = new MyCallAble();
        FutureTask task = new FutureTask(callAble);
        Thread t3 = new Thread(task);
        t3.start();

        try {
            Object o = task.get();
            System.out.println(o.getClass().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //线程池
    }


}

class MyTest extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread创建线程");
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("实现runnable形式创建线程");
    }
}


class MyCallAble implements Callable{
    @Override
    public Object call() throws Exception {
        return "callable value创建线程";
    }
}