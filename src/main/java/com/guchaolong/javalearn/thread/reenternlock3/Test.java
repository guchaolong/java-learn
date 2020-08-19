package com.guchaolong.javalearn.thread.reenternlock3;

/**
 * Description:
 *
 * @author AA
 * @date 2020/8/20 2:56
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
