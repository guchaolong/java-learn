package com.guchaolong.javalearn.io1.nettynio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/13 22:17
 */

/**
 * 单线程的netty的版本
 */
public class NettyNIO {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup(1);

        ServerBootstrap boot = new ServerBootstrap();

        try {
            boot.group(boss, boss)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new MyInbound());
                        }
                    });
            ChannelFuture future = boot.bind(9090).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyInbound extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
