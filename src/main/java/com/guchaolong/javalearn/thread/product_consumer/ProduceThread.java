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
 * @date 2019/4/27 11:22
 */
public class ProduceThread extends Thread {
    private Produce p;
    public ProduceThread(Produce p){
        this.p = p;
    }
    @Override
    public void run() {
        while (true) {
            p.produce();
        }
    }
}