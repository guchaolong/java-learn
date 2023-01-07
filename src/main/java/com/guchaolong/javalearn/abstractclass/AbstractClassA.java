package com.guchaolong.javalearn.abstractclass;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/20 5:17
 */
public abstract class AbstractClassA {
    private int f1(){
        return 1;
    }
    /** abstract不能和final private static共存*/
    abstract int f2();
}
