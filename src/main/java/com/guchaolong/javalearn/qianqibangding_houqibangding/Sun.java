package com.guchaolong.javalearn.qianqibangding_houqibangding;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/25 23:58
 */
public class Sun extends Father {
    static void static_play(){
        System.out.println("Sun static play");
    }

    //无法重写父类的final方法，否则 编译报错
//    final void final_play(){
//        System.out.println("Sun final play");
//    }

    private void private_play(){
        System.out.println("Sun private play");
    }

    @Override
    void other_play(){
        System.out.println("Sun other play");
    }
}
