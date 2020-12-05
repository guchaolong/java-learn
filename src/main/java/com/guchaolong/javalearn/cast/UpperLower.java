package com.guchaolong.javalearn.cast;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/2 20:51
 */
public class UpperLower {
    public static void main(String[] args) {
        char c = (char) ('B' + 'a' - 'A');
        char [] cc = {'a', 'b', 'c', 'z','A', 'B', 'C','Z'};
        for (char c1 : cc) {
            System.out.println((int)c1);
        }
    }
}
