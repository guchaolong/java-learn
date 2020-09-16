package com.guchaolong.javalearn.product_consume;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/16 15:41
 */
public class Consumer implements Runnable {

    private LinkedBlockingQueue<Integer> queue;

    public Consumer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer take = queue.take();
                System.out.println("consume " + take + " left " + queue.size());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("queue is empty " + queue.size());
                e.printStackTrace();
            }
        }
    }
}
