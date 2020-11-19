package com.self.javalearn.baselearn.stack;

/**
 * @ClassName Stack
 * @Author 51205 TRN
 * @Date 2020/11/19 10:48
 * @Version 1.0
 * @Description Class Function Description Here
 */
public interface Stack<T> {
    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 压进去元素
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素，未出栈
     * @return
     */
    T peek();

    /**
     * 弹出站定元素
     * @return
     */
    T pop();
}
