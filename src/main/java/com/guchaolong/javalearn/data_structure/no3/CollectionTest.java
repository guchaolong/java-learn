package com.guchaolong.javalearn.data_structure.no3;

import java.util.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 3:07
 */
public class CollectionTest {
    public static void main(String[] args) {
        /**
         * 1. Collection:是一个接口，实现有List Set Queue
         * 2. Stack继承自Vector，Vector实现List,也属于Collection
         * 3. Collections是一个工具类，不能实例化，因为构造函数私有，提供了静态方法用于Collection下的对象的排序等功能
         */
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("11");
        queue.add("22");
        queue.add("33");
        queue.add("44");
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());


        Collections.sort(list);

        Stack<String> stack = new Stack<>();

    }
}
