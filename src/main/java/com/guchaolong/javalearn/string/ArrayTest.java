package com.guchaolong.javalearn.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/4 22:08
 */
public class ArrayTest {
    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }

    public static ArrayList<String> Permutation(String str) {
        char[] arr = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        if(str == null){
            return null;
        }
        build(list, 0, arr);
        Collections.sort(list);
        return list;
    }

    private static void build(ArrayList list, int i, char[] c){
        if(i == c.length - 1){
            list.add(new String(c));
        }

        for(int j = i; j < c.length; j++){
            if(i != j && c[j] == c[i]){
                continue;
            }else{
                c = swap(c, i, j);
                build(list, i + 1, c);
                c = swap(c, i, j);
            }
        }
    }

    private static char[] swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }
}
