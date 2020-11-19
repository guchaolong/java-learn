package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 2:50
 */
public class StringBufferStringBuilder {
    public static void main(String[] args) {
        String str = "hello";
        StringBuffer sb1 = new StringBuffer("hello");
        sb1.append(" world");
        StringBuilder sb2 = new StringBuilder("hello");
        sb2.append(" world");
    }
}
