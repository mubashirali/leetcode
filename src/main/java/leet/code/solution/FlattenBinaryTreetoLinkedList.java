package leet.code.solution;


import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreetoLinkedList {

    /**
     * 114. Flatten Binary Tree to Linked List
     * Solved
     * Medium
     * Topics
     * premium lock iconCompanies
     * Hint
     * <p>
     * Given the root of a binary tree, flatten the tree into a "linked list":
     * <p>
     * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
     * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [1,2,5,3,4,null,6]
     * Output: [1,null,2,null,3,null,4,null,5,null,6]
     * <p>
     * Example 2:
     * <p>
     * Input: root = []
     * Output: []
     * <p>
     * Example 3:
     * <p>
     * Input: root = [0]
     * Output: [0]
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 2000].
     * -100 <= Node.val <= 100
     * <p>
     * <p>
     * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
     *
     * @param args
     */
    public static void main(String[] args) {
        // Example usage:
        // Construct a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        preOrder(root, queue);
        root.left = null;
        queue.poll();
        TreeNode temp = root;
        while (!queue.isEmpty()) {
            temp.right = new TreeNode(queue.poll());
            temp = temp.right;
        }
    }

    public static void preOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.add(root.val);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
