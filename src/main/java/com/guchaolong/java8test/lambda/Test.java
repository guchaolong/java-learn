package com.guchaolong.java8test.lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/14 6:03
 */
public class Test {
    public static void main(String[] args) {

        int[] arr = {12, 58, 3, 48, 96, 56};
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println("arr 最小值为" + min);

        //jdk8
        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(IntStream.of(arr).parallel().min().getAsInt());

        //lambda
        Runnable lambda = () -> System.out.println("lambda");
        new Thread(lambda).start();

        Function<Integer, String> function = (i) -> "hello" + i;
        System.out.println(function.apply(6));

    }
}
