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
 * @date 2018/12/28 1:29
 */
public class Ftest {
    public static void main(String[] args) {
        DisplayMessage displayMessage = new DisplayMessage("hello!");
        Thread thread1 = new Thread(displayMessage);
        thread1.start();
        DisplayMessage goodby = new DisplayMessage("BY");
        Thread thread2 = new Thread(goodby);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        thread2.start();

        GuessThread guessThread = new GuessThread(6);
        guessThread.start();
        try {
            guessThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}