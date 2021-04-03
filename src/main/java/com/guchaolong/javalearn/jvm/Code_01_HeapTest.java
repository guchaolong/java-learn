package com.guchaolong.javalearn.jvm;

import java.util.ArrayList;

/**
 * Description:
 * jvisualvm查看heap的gc情况
 * @author GUCHAOLONG
 * @date 2021/4/2 15:19
 */
public class Code_01_HeapTest {
    byte[] bytes = new byte[1024 * 100];
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Code_01_HeapTest> list = new ArrayList<>();
        while (true){
            list.add(new Code_01_HeapTest());
            Thread.sleep(10);
        }

    }
}
