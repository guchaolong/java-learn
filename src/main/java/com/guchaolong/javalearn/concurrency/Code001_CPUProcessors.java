package com.guchaolong.javalearn.concurrency;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/25 16:25
 */
public class Code001_CPUProcessors {
    public static void main(String[] args) {
        //cup数  处理器核的数目
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
