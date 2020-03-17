package com.algo.bst;

import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        left = null;
        right = null;
        this.value = value;
    }

}

interface Tree {
    public void insert(int value);

    public void delete(int value);

    public Node search(int value);

    public void preOrder();

    public void postOrder();

    public void inOrder();

    public void branchSum();

    public void invert();

}

class BST implements Tree {

    Node root;

    BST() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {

        if (node == null) {
            return;
        }
        display(node.left);
        System.out.println(node.value);
        display(node.right);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public void delete(int value) {
        delete(root, value);
    }


    public Node search(int value) {
        return search(root, value);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public Node calculateSum(Node node, int currSum, List<Integer> sumList) {

        if (node == null) {
            return null;
        }

        currSum = currSum + node.value;

        if ((node.left == null) && (node.right == null)) {
            sumList.add(currSum);
            return node;
        }

        calculateSum(node.left, currSum, sumList);
        calculateSum(node.right, currSum, sumList);

        return node;
    }


    public void branchSum() {
        List<Integer> sumList = new ArrayList<Integer>();
        calculateSum(root, 0, sumList);

        System.out.println(sumList.toString());

    }

    @Override
    public void invert() {
        invert(root);
    }


    public Node preOrder(Node node) {
        if (node == null)
            return null;

        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);

        return node;
    }

    public Node postOrder(Node node) {
        if (node == null)
            return null;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);

        return node;
    }

    public Node inOrder(Node node) {
        if (node == null)
            return null;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);

        return node;
    }

    public Node invert(Node node) {

        if(node == null)
            return null;

        invert(node.left);
        invert(node.right);

        Node temp = null;
        temp = node.left;
        node.left = node.right;
        node.right = temp;

        return node;
    }

    private Node search(Node node, int value) {

        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node = search(node.left, value);
        } else if (value > node.value) {
            node = search(node.right, value);
        } else if (value == node.value) {
            return node;
        }

        return node;
    }


    private Node delete(Node node, int value) {

        return node;
    }


    public static void main(String args[]) {
        BST bst = new BST();
        bst.insert(390);
        bst.insert(395);
        bst.insert(50);
        bst.insert(45);
        bst.insert(70);
        bst.insert(400);
        bst.insert(2000);

        bst.display();
        //bst.delete(400);
        if (bst.search(900) != null) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }


        System.out.println("PreOrder");
        bst.preOrder();

        System.out.println("InOrder");
        bst.inOrder();

        System.out.println("postOrder");
        bst.postOrder();

        bst.branchSum();

        bst.invert();

        System.out.println("After Invert");
        bst.inOrder();

    }
}
