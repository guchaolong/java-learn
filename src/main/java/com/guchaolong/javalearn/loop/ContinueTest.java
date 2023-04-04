package com.guchaolong.javalearn.loop;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/3/22 03:47
 */
public class ContinueTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if(i == 5){
                System.out.println("continue");
                continue;
            }
            System.out.println("i = " + i);

        }
    }
}
