package com.self.javalearn.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName MessageEncoder
 * @Author 51205
 * @Date 2020/12/12 14:51
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol, ByteBuf byteBuf) throws Exception {
        System.out.println("encoder 被调用");
        byteBuf.writeInt(messageProtocol.getLen());
        byteBuf.writeBytes(messageProtocol.getContent());
    }
}
