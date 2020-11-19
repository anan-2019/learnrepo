package com.self.javalearn.baselearn.tree;

/**
 * @ClassName TestTree
 * @Author 51205 TRN
 * @Date 2020/11/19 14:07
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class TestTree {
    private Node root;

    public void insertNode(int iData, double dData){
        Node newNode = new Node();
        newNode.iData = iData;
        newNode.dData = dData;

        if (root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (iData < current.iData){
                    current = current.leftNode;
                    if (current == null){
                        parent.leftNode = newNode;
                        return;
                    }
                }else {
                    current = current.rightNode;
                    if (current == null){
                        parent.rightNode = newNode;
                        return;
                    }
                }
            }
        }
    }
}
