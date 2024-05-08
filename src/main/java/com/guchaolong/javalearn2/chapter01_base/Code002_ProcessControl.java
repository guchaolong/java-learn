package com.guchaolong.javalearn2.chapter01_base;

import java.util.Scanner;

/**
 * Description:流程控制
 *
 * @author Ezekiel
 * @date 2024/5/9 02:41
 */
public class Code002_ProcessControl {
    public static void main(String[] args) {
        formatPrint();
        input();
    }

    /**
     * 格式化输出
     */
    public static void formatPrint() {

        //println是print line的缩写，表示输出并换行。因此，如果输出后不想换行，可以用print()：
        // 如果输出后不想换行，可以用print()
        System.out.print("H,");
        System.out.print("e,");
        System.out.print("l,");
        System.out.print("l,");
        System.out.println("o");

        //Java还提供了格式化输出的功能。为什么要格式化输出？因为计算机表示的数据不一定适合人来阅读：
        double d = 12900000;
        System.out.println(d);// 1.29E7

        //如果要把数据显示成我们期望的格式，就需要使用格式化输出的功能。
        //格式化输出使用System.out.printf()，通过使用占位符%?，printf()可以把后面的参数格式化成指定格式：
        double d2 = 3.1415926;
        System.out.printf("%.2f\n", d2); // 3.14  保留两位小数
        System.out.printf("%.3f\n", d2); // 3.142    保留三位小数
        System.out.printf("%.4f\n", d2); // 3.1416          保留四位小数

        //Java的格式化功能提供了多种占位符，可以把各种数据类型“格式化”成指定的字符串：
        //%d	格式化输出整数
        //%x	格式化输出十六进制整数
        //%f	格式化输出浮点数
        //%e	格式化输出科学计数法表示的浮点数
        //%s	格式化字符串
        //%c	格式化字符
        //%b	格式化布尔值（true/false）
        System.out.println("Hello, world!");
        System.out.printf("Hello, %s!\n", "world");
        System.out.printf("Hello, %s, %d!\n", "world", 2021);
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数
    }

    public static void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的年龄:");
        int age = scanner.nextInt();
        System.out.println("您的年龄是：" + age);
    }
}
