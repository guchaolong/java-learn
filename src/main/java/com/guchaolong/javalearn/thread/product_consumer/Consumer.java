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
 * @date 2019/4/27 11:19
 */
public class Consumer {

    public Object object;
    public ArrayList<Integer> list;//用list存放生产之后的数据，最大容量为1

    public Consumer(Object object,ArrayList<Integer> list ){
        this.object = object;
        this.list = list;
    }

    public void consumer() {
        synchronized (object) {
            try {
                /*只有list不为空时才会去进行消费操作*/
                while(list.isEmpty()){
                    System.out.println("消费者" + Thread.currentThread().getName() + " waiting");
                    object.wait();
                }
                System.out.println("消费了" + list.get(0));
                list.clear();
                System.out.println("消费者" + Thread.currentThread().getName() + " Runnable");
                object.notifyAll();//然后去唤醒因object调用wait方法处于阻塞状态的线程
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
