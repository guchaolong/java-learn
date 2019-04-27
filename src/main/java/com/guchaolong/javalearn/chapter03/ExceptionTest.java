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
package com.guchaolong.javalearn.chapter03;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/9 0:35
 */

/**
 * Object->ThrowAble->Error 和 Exception
 * Error是程序本身无法处理的 如内存耗尽
 * Exception分为运行时异常（如空指针） 和非运行时异常
 * Java要求处理非运行时异常  捕获或者抛出
 *
 *
 * 一：
 * try catch 捕获
 * 异常在代码顺序执行过程中发生，捕获到异常时，会在catch中处理
 * 处理完之后接着执行
 *
 *
 * 以下第50行会异常   输出为：
 *
 * 如果UTF-8有异常我和我之后就不会被执行了
 * Disconnected from the target VM, address: '127.0.0.1:50812', transport: 'socket'
 * 异常了
 * java.io.UnsupportedEncodingException: ABC
 * Ok
 */
public class ExceptionTest {


    public static void encoding(String str){
        try {
            str.getBytes("UTF-8");
            System.out.println("如果UTF-8有异常我和我之后就不会被执行了");
            str.getBytes("ABC");
            System.out.println("如果ABC有异常我和我之后就不会被执行了");

        } catch (UnsupportedEncodingException e) {
            System.out.println("异常了");
            System.out.println(e);
        }
    }

    public static void main(String [] args){
        encoding("hello");
        System.out.println("Ok");
    }


}