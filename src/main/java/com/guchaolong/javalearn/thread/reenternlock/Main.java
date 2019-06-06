/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/6 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.reenternlock;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/6 23:05
 */
public class Main {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA();
        new Thread(()->{
            int i = 6;
            while (i>=0){
                serviceA.test1();
                i--;
            }
        }).start();
        new Thread(()->{
            int i = 7;
            while (i>=0){
                serviceA.test2();
                i--;
            }
        }).start();
    }
}