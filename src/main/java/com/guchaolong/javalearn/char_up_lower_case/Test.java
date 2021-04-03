package com.guchaolong.javalearn.char_up_lower_case;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/28 10:07
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(isNumber('5'));
    }

    //判断字符是否属于0-9
    public static boolean isNumber(char c){
        if(c - '0' >= 0 && c - '9' <= 0){
            return true;
        }
        return false;
    }
}
