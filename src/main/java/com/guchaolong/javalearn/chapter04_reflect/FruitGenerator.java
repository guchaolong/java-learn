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
 * @date 2018/12/9 21:42
 */

/**
 * 未传入泛型实参时 实现类后面必须要有<T> 否则报错
 *
 */
public class FruitGenerator implements Generator<String> {
    @Override
    public String next() {
        return null;
    }
}