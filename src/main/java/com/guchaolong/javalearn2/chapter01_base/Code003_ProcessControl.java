package com.guchaolong.javalearn2.chapter01_base;

/**
 * Description:流程控制
 *
 * @author Ezekiel
 * @date 2024/5/9 02:41
 */
public class Code003_ProcessControl {
    public static void main(String[] args) {
        ifTest1();
        ifTest2();

    }

    // if 语句
    public static void ifTest1() {
        int n = 70;
        if (n >= 60) {
            System.out.println("及格了");
        }
        System.out.println("END");
    }


    // if-else 语句
    public static void ifTest2() {
        int n = 70;
        if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("不及格了");
        }
        System.out.println("END");
    }

    // if-else 语句
    public static void ifTest3() {
        int n = 70;
        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 80) {
            System.out.println("良好");
        } else if (n >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
        System.out.println("END");
    }

    //串联使用多个if时，要特别注意判断顺序。观察下面的代码：
    //执行发现，n = 100时，满足条件n >= 90，
    // 但输出的不是"优秀"，而是"及格了"，
    // 原因是if语句从上到下执行时，先判断n >= 60成功后，
    // 后续else不再执行，因此，if (n >= 90)没有机会执行了
    //正确的方式是按照判断范围从大到小依次判断：ifTest3
    public static void ifTest4() {
        int n = 100;
        if (n >= 60) {
            System.out.println("及格了");
        } else if (n >= 90) {
            System.out.println("优秀");
        } else {
            System.out.println("挂科了");
        }
    }


}
