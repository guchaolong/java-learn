package com.guchaolong.javalearn.string;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/2 23:18
 */
public class Test {
    public static void main(String[] args) {
        int acfgcfge = solve("acfgcfge");
        System.out.println(acfgcfge);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int solve (String a) {
        // write code here
        int mid = a.length() / 2;
        while(mid > 0){
            loop:
            for(int i = 0; i + mid * 2 <= a.length(); i++){
                for(int j = i; j < i + mid; j++){
                    if(a.charAt(j) != a.charAt(j + mid)){
                        continue loop;
                    }
                }
                return mid * 2;
            }

            mid--;
        }
        return 0;
    }
}
