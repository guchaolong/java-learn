package com.guchaolong.javalearn.qianqibangding_houqibangding;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/26 0:00
 */
public class Main {
    public static void main(String[] args) {
        Father obj = new Sun();
        invoke(obj);
        StringBuffer sb = new StringBuffer();
        sb.append("a");
        //Father static play
        //Father final play
        //Sun other play
        //构造函数 以及 static final private修饰的都是前绑定，其他的是后绑定

    }

    static void invoke(Father obj){
        obj.static_play();
        obj.final_play();
        obj.other_play();
    }
}
