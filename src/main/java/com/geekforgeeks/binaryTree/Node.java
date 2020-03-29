package com.geekforgeeks.binaryTree;

public class Node {
    int ele;
    Node left;
    Node right;

    Node(int ele) {
        this.ele = ele;
        this.left = this.right = null;
    }

    public int getEle() {
        return ele;
    }

    public void setEle(int ele) {
        this.ele = ele;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ele=" + ele +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
