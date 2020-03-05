package com.algo.bst;

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
        bst.insert(50);
        bst.insert(400);
        bst.insert(2000);

        bst.display();
        //bst.delete(400);
        if (bst.search(900) != null) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
