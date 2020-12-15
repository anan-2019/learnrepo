package com.self.javalearn.protocoltcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName MessageProtocol
 * @Author 51205
 * @Date 2020/12/12 14:41
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
