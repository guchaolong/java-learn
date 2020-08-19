package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/19 16:04
 */
public class FatherNewClass {
    static {
        System.out.println("父类-静态代码块");
    }

    {
        System.out.println("父类-构造代码块");
    }

    FatherNewClass(){
        System.out.println("父类-构造函数");
    }
}
