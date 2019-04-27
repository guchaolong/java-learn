/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/28 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.ThreadTest;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 1:20
 */
public class DisplayMessage implements Runnable {
    private String message;
    DisplayMessage(String message){
        this.message = message;
    }

    @Override
    public void run() {
        while (true)
        System.out.println(message);
    }
}