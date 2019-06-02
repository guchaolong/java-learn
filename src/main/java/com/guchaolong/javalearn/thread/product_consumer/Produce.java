/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: design-pattern
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/4/27 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.product_consumer;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/4/27 11:10
 */
public class Produce {
    public Object object;
    public ArrayList<Integer> list;

    public Produce(Object object, ArrayList<Integer> list) {
        this.object = object;
        this.list = list;
    }

    public void produce() {
        synchronized (object) {
            try {
                while (!list.isEmpty()) {
                    System.out.println("生产者" + Thread.currentThread().getName() + "waiting");
                    object.wait();
                }
                int value = 9999;
                list.add(value);
                System.out.println("生产者" + Thread.currentThread().getName() + "runnable");
                object.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}