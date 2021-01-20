package com.guchaolong.javalearn.base.impl;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/1/18 0:39
 */
public class ClassA implements InterfaceA, InterfaceB {

    //同时实现两个接口，两个接口都有方法f1(),如果返回类型不一样，那么是不能通过编译的，如果一样，实现一次就行了
    @Override
    public int f1() {
        return 0;
    }
}
