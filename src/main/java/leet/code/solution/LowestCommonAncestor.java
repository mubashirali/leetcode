package leet.code.solution;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }


    /**
     * Runtime: 4 ms
     * Memory Usage: 39.7 MB
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        final TreeNode nodeLeft = lowestCommonAncestor(root.left, p, q);
        final TreeNode nodeRight = lowestCommonAncestor(root.right, p, q);

        if (nodeLeft != null && nodeRight != null) {
            return root;
        } else {
            return nodeLeft != null ? nodeLeft : nodeRight;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
