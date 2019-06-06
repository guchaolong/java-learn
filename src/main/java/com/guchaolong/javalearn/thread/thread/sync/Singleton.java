/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/7 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.thread.sync;

/**
 * Description:
 * <p>
 * 双重检验锁方式实现单利模式
 *
 * @author guchaolong
 * @date 2019/6/7 0:52
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }
    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}