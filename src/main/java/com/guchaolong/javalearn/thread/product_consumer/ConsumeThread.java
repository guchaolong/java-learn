/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: design-pattern
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/4/27 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.product_consumer;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/4/27 11:23
 */
public class ConsumeThread extends Thread {
    private Consumer c;
    public ConsumeThread(Consumer c){
        this.c = c;
    }
    @Override
    public void run() {
        while (true) {
            c.consmer();
        }
    }
}