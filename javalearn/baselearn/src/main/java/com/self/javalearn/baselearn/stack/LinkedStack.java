package com.self.javalearn.baselearn.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @ClassName LinkedStack
 * @Author 51205 TRN
 * @Date 2020/11/19 9:55
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class LinkedStack<T> implements Stack<T>, Serializable {
    private static Logger logger = LoggerFactory.getLogger(LinkedStack.class);

    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = new Node<>();
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top ==null || top.data == null;
    }

    @Override
    public void push(T data) {
        if (data == null){
            throw new EmptyStackException();
        }

        if (this.top == null){
            this.top = new Node<>(data);
        }else if (this.top.data==null){
            this.top.data = data;
        }else {
            Node<T> p = new Node<>(data,this.top);
            top = p;
        }
        size ++;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw  new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    //测试
    public static void main(String[] args) {
        LinkedStack<String> sl = new LinkedStack<>();
        sl.push("123");
        sl.push("1234");
        sl.push("1234");
        int length = sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println(sl.pop());
        }
    }
}
