package com.self.javalearn.rpc;

import com.self.javalearn.protocoltcp.MessageDecoder;
import com.self.javalearn.protocoltcp.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ServerHandlerInitial
 * @Author 51205
 * @Date 2020/12/12 14:07
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ServerHandlerInitial extends ChannelInitializer<SocketChannel> {
    private static Logger logger = LoggerFactory.getLogger(ServerHandlerInitial.class);

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new MessageEncoder());
        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new ServerChannelHandler());
    }
}
