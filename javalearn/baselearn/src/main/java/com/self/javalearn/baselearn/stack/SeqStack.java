package com.self.javalearn.baselearn.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EmptyStackException;

/**
 * @ClassName SeqStack
 * @Author 51205 TRN
 * @Date 2020/11/19 13:09
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class SeqStack<T> implements Stack<T> {
    private static Logger logger = LoggerFactory.getLogger(SeqStack.class);
    private int top = -1;
    private int capactity = 10;

    private T[] array;
    private int size;

    public SeqStack(int capactity) {
        array = (T[]) new Object[capactity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capactity];
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        if (array.length == size){
            ensuerCapacity(size * 2 +1);
        }

        array[++top] = data;
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    private void ensuerCapacity(int capactity){
        if (capactity < size){
            return;
        }

        T[] old = array;
        array = (T[]) new Object[capactity];

        for (int i = 0; i < size; i++) {
            array[i] = old[i];
        }
    }

    public static void main(String[] args) {
        SeqStack<String> seqStack = new SeqStack();
        seqStack.push("1234");
        seqStack.push("123");
        seqStack.push("12");
        seqStack.push("1");
        int size = seqStack.getSize();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(seqStack.pop());
        }
    }
}
