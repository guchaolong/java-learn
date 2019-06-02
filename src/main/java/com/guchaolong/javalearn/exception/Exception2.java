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
package com.guchaolong.javalearn.exception;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/9 0:55
 */
public class Exception2 {

    public static void encoding(String str) throws Exception{
            str.getBytes("UTF-8");
            System.out.println("如果UTF-8有异常我和我之后就不会被执行了");

            str.getBytes("ABC");
            System.out.println("如果ABC有异常我和我之后就不会被执行了");
    }

    public static void main(String [] args){
        try {
            encoding("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ok");
    }
}