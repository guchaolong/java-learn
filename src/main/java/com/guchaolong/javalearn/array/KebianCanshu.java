package com.guchaolong.javalearn.array;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/18 23:37
 */
public class KebianCanshu {
    public static int sum(int... numbers){
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = sum(0);
        System.out.println(a);
        int b = sum(0,1,2);
        System.out.println(b);
        int c = sum(new int[]{1,2,3});
        System.out.println(c);
    }
}
