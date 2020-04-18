package leet.code.solution;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeBST {

    public static void main(String[] args) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(6);
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(4);
        binarySearchTree.addNode(7);

        DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
        deleteNodeBST.deleteNode(binarySearchTree.getHead(), 3);

        binarySearchTree.printBFS(binarySearchTree.getHead());
    }

    public BinarySearchTree.Node deleteNode(BinarySearchTree.Node root, int key) {
        if(root == null) return root;

        if(key < root.getValue()) {
            root.setLeft(deleteNode(root.getLeft(), key));
        } else if(key > root.getValue()) {
            root.setRight(deleteNode(root.getRight(), key));
        } else {
            // node with no leaf nodes
            if(root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting "+key);
                return null;
            } else if(root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting "+key);
                return root.getRight();
            } else if(root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting "+key);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setValue(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println("deleting "+key);
            }
        }

        return root;
    }

    private int minValue(BinarySearchTree.Node node) {

        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getValue();
    }
}
