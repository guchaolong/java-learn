package com.guchaolong.javalearn.io.netty.simple;

import io.netty.util.NettyRuntime;

public class Test {
    public static void main(String[] args) {
        //返回当前系统的CPU核数
        System.out.println(NettyRuntime.availableProcessors());
    }
}
