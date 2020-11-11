package com.guchaolong.javalearn.cast;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/20 13:13
 */
public class CharToInt {
    public static void main(String[] args) {
        String sdf = "346456";
        char c = sdf.charAt(2);
        int i = c - '0';
        System.out.println(i + 5);
    }
}
