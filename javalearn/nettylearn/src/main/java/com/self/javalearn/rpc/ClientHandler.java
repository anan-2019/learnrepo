package com.self.javalearn.rpc;

import com.self.javalearn.protocoltcp.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName ClientHandler
 * @Author 51205
 * @Date 2020/12/12 13:56
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private static Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i =0; i< 20; i++){
            MessageProtocol messageProtocol = new MessageProtocol();
            byte[] bytes = "tets".getBytes(StandardCharsets.UTF_8);
            messageProtocol.setLen(bytes.length);
            messageProtocol.setContent(bytes);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol message) throws Exception {

        System.out.println("客户端接收到数据 " + new String(message.getContent(),StandardCharsets.UTF_8));
        System.out.println("客户端收到次数= " + (++ this.count));

    }
}
