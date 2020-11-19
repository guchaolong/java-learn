package com.guchaolong.javalearn.base.instanceoftest;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 2:24
 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();

        System.out.println(p instanceof InterfaceA);
        System.out.println(p instanceof Person);
    }
}
