package com.guchaolong.javalearn.switchtest;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/19 23:44
 */
public class Test {
    public static void main(String[] args) {
        String str = "hello";
//        'char, byte, short, int, Character, Byte, Short, Integer, String, enum

        switch (str) {
            case "h":
                System.out.println("h");
            case "hell":
                System.out.println("hell");
            default:
                System.out.println("hello");
        }
    }
}
