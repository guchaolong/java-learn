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
 * @date 2018/12/9 18:16
 */
public class PraisTest {

    public static void main(String [] args){
        Prais<String> prais = new Prais("ds","f");
        System.out.println(prais.getFirst());
    }
}