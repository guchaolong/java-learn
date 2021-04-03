package com.guchaolong.javalearn.qianqibangding_houqibangding;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/25 23:56
 */
public class Father {
    static void static_play(){
        System.out.println("Father static play");
    }

    final void final_play(){
        System.out.println("Father final play");
    }

    private void private_play(){
        System.out.println("Father private play");
    }

    void other_play(){
        System.out.println("Father other play");
    }
}
