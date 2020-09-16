package com.guchaolong.javalearn.product_consume;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/16 15:33
 */
public class Producer implements Runnable {

    public LinkedBlockingQueue<Integer> QUEUE;

    public Producer(LinkedBlockingQueue<Integer> queue) {
        QUEUE = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                int i = new Random().nextInt();
                QUEUE.put(i);
                System.out.println("product " + i + " queue size " + QUEUE.size());
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("queue is full" + QUEUE.size());
                e.printStackTrace();
            }
        }
    }
}
