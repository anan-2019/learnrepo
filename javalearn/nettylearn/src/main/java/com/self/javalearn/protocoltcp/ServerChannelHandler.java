package com.self.javalearn.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

/**
 * @ClassName ServerChannelHandler
 * @Author 51205
 * @Date 2020/12/12 14:13
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ServerChannelHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private static Logger logger = LoggerFactory.getLogger(ServerChannelHandler.class);

    private int count;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 注册成功");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol message) throws Exception {

        System.out.println("服务器接收到数据 " + new String(message.getContent(),StandardCharsets.UTF_8));
        System.out.println("服务器收到次数= " + (++ this.count));

        //服务器回送数据
        MessageProtocol messageProtocol = new MessageProtocol();
        byte[] bytes =("我收到了你的数据" + UUID.randomUUID().toString()).getBytes(StandardCharsets.UTF_8);
        messageProtocol.setLen(bytes.length);
        messageProtocol.setContent(bytes);
        channelHandlerContext.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "离线成功");
    }


}
