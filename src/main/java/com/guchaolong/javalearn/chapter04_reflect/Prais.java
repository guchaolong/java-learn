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
 * @date 2018/12/9 18:15
 */
public class Prais<T> {
    private T first;
    private T last;

    public Prais(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}