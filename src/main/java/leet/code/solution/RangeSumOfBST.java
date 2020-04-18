package leet.code.solution;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    /**
     * Runtime: 1 ms
     * Memory Usage: 46.3 MB
     */
    public static int rangeSumBST(BinarySearchTree.Node root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinarySearchTree.Node node = queue.poll();

            if (node.value >= L && node.value <= R) {
                sum += node.value;
            }
            if (R > node.value && node.right != null) {
                queue.add(node.right);
            }
            if (L <= node.value && node.left != null) {
                queue.add(node.left);
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.addNode(10);
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(15);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(7);
        binarySearchTree.addNode(18);

        rangeSumBST(binarySearchTree.getHead(), 7, 15);
        binarySearchTree.printBFS(binarySearchTree.getHead());
    }
}
