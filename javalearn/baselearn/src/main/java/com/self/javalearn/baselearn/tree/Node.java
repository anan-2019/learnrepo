package com.self.javalearn.baselearn.tree;

/**
 * @ClassName Node
 * @Author 51205 TRN
 * @Date 2020/11/19 14:04
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Node {
    public int iData;
    public double dData;
    public Node leftNode;
    public Node rightNode;

    public void showNode() {
        System.out.println("{" + iData + "," + dData + "}");
    }
}
