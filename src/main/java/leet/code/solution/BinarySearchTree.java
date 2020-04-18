package leet.code.solution;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree {

    private Node head;

    public static void main(String[] args) {
//        final BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.addNode(4);
//        binarySearchTree.addNode(1);
//        binarySearchTree.addNode(6);
//        binarySearchTree.addNode(0);
//        binarySearchTree.addNode(2);
//        binarySearchTree.addNode(5);
//        binarySearchTree.addNode(7);
//        binarySearchTree.addNode(3);
//        binarySearchTree.addNode(8);

    }

    private boolean isBinarySearchTree(Node head) {
        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getLeft() != null) {
                if (node.getLeft().getValue() > node.getValue()) {
                    return false;
                }
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                if (node.getRight().getValue() <= node.getValue()) {
                    return false;
                }
                queue.add(node.getRight());
            }
        }
        return true;
    }

    private int findMin(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        if (node.getLeft() != null) {
            return findMin(node.getLeft());
        }

        return node.getValue();
    }


    public void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.getLeft());

        System.out.print(node.getValue() + " ");

        printInorder(node.getRight());
    }

    @SuppressWarnings("Duplicates")
    public void printBFS(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.value);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

    }

    public void addNode(int i) {
        if (head == null) {
            head = new Node(i);
        } else {
            insertNewNode(head, i);
        }
    }

    private Node insertNewNode(Node head, int i) {
        if (head == null) {
            return new Node(i);
        }

        if (i <= head.getValue()) {
            head.setLeft(insertNewNode(head.getLeft(), i));
        } else {
            head.setRight(insertNewNode(head.getRight(), i));
        }

        return head;
    }

    public Node getHead() {
        return head;
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int i) {
            value = i;
        }


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
