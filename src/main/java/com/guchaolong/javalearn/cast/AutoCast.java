package com.guchaolong.javalearn.cast;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 10:11
 */
public class AutoCast {
    public static void main(String[] args) {
        byte b1 = 127;
        byte b2 = 127;
//        b1 = b1 + b2; //编译报错 b1 + b2的结果为int类型，不能赋值给byte类型的b1

        // +=会自动类型转换
        b1 += b2;
    }
}
