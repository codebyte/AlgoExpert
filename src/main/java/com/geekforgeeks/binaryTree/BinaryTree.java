package com.geekforgeeks.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

interface TreeOps {
    public void insert(int ele);

    public void preOrder();

    public void inOrder();

    public void postOrder();

    public void bfs();

    public void bfsLine();

    public int sizeOfBinaryTree();

    public boolean search(int ele);

    public void delete(int ele);

}


public class BinaryTree implements TreeOps {

    Node root = null;

    @Override
    public void insert(int ele) {
        root = insert(root, ele);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public void bfs() {
        bfs(root);
    }

    @Override
    public void bfsLine() {
        bfsLine(root);
    }

    @Override
    public int sizeOfBinaryTree() {
        return sizeOfBinaryTree(root);
    }

    @Override
    public boolean search(int ele) {
        return search(root, ele);
    }

    @Override
    public void delete(int ele) {

        Node node = findElementToDelete(root, ele);

    }

    public Node findElementToDelete(Node node, int ele) {

        if (node == null) {
            return null;
        }

        if (ele < node.ele) {
            node.left = findElementToDelete(node.left, ele);
        } else if (ele > node.ele) {
            node.right = findElementToDelete(node.right, ele);
        } else {

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }


            Node succ = getSucc(node);
            System.out.println("Succee" + succ.ele);
            node.ele = succ.ele;
            node.right = findElementToDelete(node.right, succ.ele);
        }

        return node;
    }


    public Node getSucc(Node node) {

        Node curr = node.right;

        while ((curr != null) && (curr.left != null)) {
            curr = curr.left;
        }

        return curr;
    }


    public boolean search(Node node, int ele) {
        boolean ret = false;

        if (node == null) {
            return false;
        }

        if (ele == node.ele) {
            return true;
        }

        if (ele < node.ele) {
            ret = search(node.left, ele);
        } else if (ele > node.ele) {
            ret = search(node.right, ele);
        }

        return ret;
    }

    public Node insert(Node node, int ele) {
        if (node == null) {
            node = new Node(ele);
            return node;
        }

        if (ele <= node.ele) {
            node.left = insert(node.left, ele);
        } else {
            node.right = insert(node.right, ele);
        }

        return node;
    }

    public void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public void bfs(Node node) {

        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while (q.isEmpty() == false) {

            Node n = q.poll();

            System.out.println(n);

            if (n.left != null) {
                q.add(n.left);
            }

            if (n.right != null) {
                q.add(n.right);
            }
        }
    }

    public void bfsLine(Node node) {

        int count = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while (q.isEmpty() == false) {

            count = q.size();

            for (int i = 0; i < count; i++) {

                Node n = q.poll();

                System.out.print(n.getEle() + " ");

                if (n.left != null) {
                    q.add(n.left);
                }

                if (n.right != null) {
                    q.add(n.right);
                }

            }

            System.out.println();
        }
    }

    public int sizeOfBinaryTree(Node node) {


        if (node == null) {
            return 0;
        }

        int count = 1;

        count += sizeOfBinaryTree(node.left);
        count += sizeOfBinaryTree(node.right);

        return count;
    }

    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("PreOrder");
        tree.preOrder();

        System.out.println("PostOrder");
        tree.postOrder();

        System.out.println("InOrder");
        tree.inOrder();

        System.out.println("Bfs");
        tree.bfs();

        System.out.println("Bfs");
        tree.bfsLine();

        System.out.println("SizeOfBinaryTree");
        System.out.println(tree.sizeOfBinaryTree());

        System.out.println("Search");
        System.out.println(tree.search(6));


        System.out.println("delete");
        tree.delete(70);

        tree.inOrder();

    }
}
