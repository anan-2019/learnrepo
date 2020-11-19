package com.self.javalearn.baselearn.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Node
 * @Author 51205 TRN
 * @Date 2020/11/19 10:53
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Node<T> {
    private static Logger logger = LoggerFactory.getLogger(Node.class);

    T data;

    Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> top) {
        this.data = data;
        this.next = top;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
