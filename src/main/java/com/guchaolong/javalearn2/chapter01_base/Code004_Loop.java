package com.guchaolong.javalearn2.chapter01_base;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2024/5/9 10:32
 */
public class Code004_Loop {
    public static void main(String[] args) {
        Integer.valueOf(123);
        forLoop();
    }

    public static void forLoop() {
        boolean flag = false;
        for (int i = 0; i <= 3; i++) {
            if (i == 0) {
                System.out.println("0");
            } else if (i == 1) {
                System.out.println("1");
                continue;
            } else if (i == 2) {
                System.out.println("2");
                flag = true;
            } else if (i == 3) {
                System.out.println("3");
                break;
            } else if (i == 4) {
                System.out.println("4");
            }
            System.out.println("xixi");
        }
        if (flag) {
            System.out.println("haha");
            return;
        }
        System.out.println("heihei");
    }
}
