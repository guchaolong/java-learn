/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/4 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.data_structure.no1_queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/4 11:08
 */
public class QueueTest {
    public static void main(String[] args) {


        Queue queue = new ArrayBlockingQueue(2);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
        System.out.println(queue.element());
        queue.add(3);
        System.out.println(queue.peek());
        queue.remove();

    }
}