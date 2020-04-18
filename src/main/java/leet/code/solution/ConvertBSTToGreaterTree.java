package leet.code.solution;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 * <p>
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class ConvertBSTToGreaterTree {

    /**
     * Runtime: 0 ms.
     * Memory Usage: 39.8 MB.
     */
    public BinarySearchTree.Node convertBST(BinarySearchTree.Node root) {

        printReverseInOrder(root, 0);

        return root;

    }

    private int printReverseInOrder(BinarySearchTree.Node node, int sum) {
        if (node == null) {
            return sum;
        }

        node.setValue(printReverseInOrder(node.getRight(), sum) + node.getValue());
        return printReverseInOrder(node.getLeft(), node.getValue());
    }

}
