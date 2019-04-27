/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/13 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.chapter05Collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/13 1:31
 */
public class QueueTest {
    public static void main(String [] args){
//        Queue<String> queue = new LinkedList<>();
//        queue.offer("first");
//        queue.offer("second");
//        queue.offer("third");
//        System.out.format("this element is %s\n",queue.remove());
//        System.out.format("this element is %s\n",queue.remove());
//        System.out.format("this element is %s\n",queue.remove());
//        if(!queue.isEmpty())
//        System.out.format("this element is %s\

//        Queue<Person> queue = new PriorityQueue<>();
//        queue.offer(new Person(1,"M"));
//        queue.offer(new Person(1,"B"));
//        queue.offer(new Person(1,"J"));
//        queue.offer(new Person(1,"A"));
//        System.out.format("this E is %s\n", queue.poll().getName());
//        System.out.format("this E is %s\n", queue.poll().getName());
//        System.out.format("this E is %s\n", queue.poll().getName());
//        System.out.format("this E is %s\n", queue.poll().getName());
        Queue<Person> queue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });


    }
}