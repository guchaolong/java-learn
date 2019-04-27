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

import java.util.Random;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/28 1:22
 */
public class GuessThread extends Thread {
    private int number;

    GuessThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println("第" + count + "次：" + guess);
        } while (guess > number);
        System.out.println("OK");
    }
}