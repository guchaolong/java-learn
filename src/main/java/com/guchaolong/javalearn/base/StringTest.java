package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/8 19:37
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "helloword";
        String str2 = "hello".substring(1,5);
        System.out.println("substring " + str2);
        char[] chars = new char[]{'h', 'e', 'l', 'l','o'};
        System.out.println(str + "-" +str.substring(2));//substring(n)  去掉前n个
        System.out.println(new String(chars, 1, 4));//offset: 起始位置（0开始），  count:字符个数
    }
}
