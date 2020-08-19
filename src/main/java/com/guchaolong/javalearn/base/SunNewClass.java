package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/19 16:07
 */
public class SunNewClass extends FatherNewClass {
    static {
        System.out.println("子类-静态代码块");
    }

    {
        System.out.println("子类-构造代码块");
    }

    SunNewClass() {
        System.out.println("子类-构造函数");
    }
}
