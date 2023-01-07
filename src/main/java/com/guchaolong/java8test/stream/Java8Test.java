/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/28 1.0          guchaolong          Creation File
 */
package com.guchaolong.java8test.stream;

import sun.net.www.content.text.Generic;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 2:43
 */
public class Java8Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1==i2);//输出false
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(i -> i).summaryStatistics();


        System.out.println(intSummaryStatistics);



        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        System.out.println(numbers.stream().map(n->n * n).distinct().collect(Collectors.toList()));
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");

        long count = list.stream().filter(String::isEmpty).count();
        System.out.println(count);
        System.out.println("length is 3:"+list.stream().filter(s->s.length()==3).count());
        System.out.println(list.stream().filter(s->!s.isEmpty()).collect(Collectors.toList()));
        String collect = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println(collect);

        Collections.shuffle(list);

    }
}