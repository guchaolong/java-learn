package com.guchaolong.javalearn.product_consume;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/16 15:44
 */
public class Test {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(15);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
