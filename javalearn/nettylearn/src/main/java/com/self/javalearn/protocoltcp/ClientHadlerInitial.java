package com.self.javalearn.protocoltcp;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ClientHadlerInitial
 * @Author 51205
 * @Date 2020/12/12 13:52
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ClientHadlerInitial extends ChannelInitializer<SocketChannel> {
    private static Logger logger = LoggerFactory.getLogger(ClientHadlerInitial.class);

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new MessageEncoder());
        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new ClientHandler());
    }

}
