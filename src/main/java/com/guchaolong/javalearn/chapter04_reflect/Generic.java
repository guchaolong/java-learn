/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/9 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.chapter04_reflect;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/9 21:29
 */

/**
 * T也可以写成其他,泛型也叫做参数化类型，这里的T就相当于一个形式参数
 * 在实例化这个泛型类的时候再指定实际类型，（实际参数）
 */
public class Generic<T> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
    public void setKey(T key) {
        this.key = key;
    }
}