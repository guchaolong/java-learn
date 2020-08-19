package com.guchaolong.javalearn.base;

import java.lang.reflect.Constructor;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/19 14:22
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //数组定义
        int[] arr1 = new int[3];

        int[] arr2 = new int[]{1, 2, 3};

        int[] arr3 = {1, 2, 3};


        //new一个对象过程
        SunNewClass sunNewClass = new SunNewClass();
        System.out.println("===============================");

        //创建对象的几种方法
        //1 new
        FatherNewClass f = new FatherNewClass();

        //2 反射 Class的newInstance
        Class clasz = Class.forName("com.guchaolong.javalearn.base.FatherNewClass");
        FatherNewClass o = (FatherNewClass)clasz.newInstance();

        //构造函数的newInstance
        Constructor<FatherNewClass> constructor = FatherNewClass.class.getConstructor();
        FatherNewClass fatherNewClass = constructor.newInstance();


    }
}
