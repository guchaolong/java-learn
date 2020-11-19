package com.guchaolong.javalearn.base;

import com.guchaolong.javalearn.base.instanceoftest.InterfaceA;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 2:29
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer a = -128;
        Integer b = -128;
        Integer c = -129;
        Integer d = -129;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
