package com.self.javalearn.rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ServerClient
 * @Author 51205
 * @Date 2020/12/12 13:46
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ServerClient {
    private static Logger logger = LoggerFactory.getLogger(ServerClient.class);

    public static void main(String[] args) {
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

       try {
           ServerBootstrap serverBootstrap = new ServerBootstrap();
          serverBootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ServerHandlerInitial());
           ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();
           channelFuture.channel().closeFuture().sync();
       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           boosGroup.shutdownGracefully();
           workGroup.shutdownGracefully();
       }
    }

}
