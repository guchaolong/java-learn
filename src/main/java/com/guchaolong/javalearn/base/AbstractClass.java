package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/1/18 0:30
 */
public abstract class AbstractClass {
    //抽象类，可以构造函数，用于给子类初始化用，不显示写的时候，默认也有
    public AbstractClass(){

    }


    public abstract void f1();
    abstract void f2();
    //抽象类可以有非抽象方法
    public final void f3(){
        System.out.println("hello");
    }


}
