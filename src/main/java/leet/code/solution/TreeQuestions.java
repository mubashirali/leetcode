public class SymmetricTree {
 /**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }else if( left == null || right == null){
            return false;
        }

        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
    
    /**
     * Balanced Binary Tree
     * Given a binary tree, determine if it is height-balanced.
     * <p>
     * For this problem, a height-balanced binary tree is defined as:
     * <p>
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = treeDepth(node.left) + 1;
        int r = treeDepth(node.right) + 1;

        return Math.max(l, r);
    } 
     
     /**
     * Invert Binary Tree
     * <p>
     * Given the root of a binary tree, invert the tree, and return its root.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

/**
 * Binary Tree Paths
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 */
    public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        String cur = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(cur);
        }
        if (root.left != null) {
            treeDFS(root.left, list, cur);
        }
        if (root.right != null) {
            treeDFS(root.right, list, cur);
        }

        return list;
    }

    private void treeDFS(TreeNode root, List<String> list, String cur) {
        cur += "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(cur);
            return;
        }
        if (root.left != null) {
            treeDFS(root.left, list, cur);
        }
        if (root.right != null) {
            treeDFS(root.right, list, cur);
        }
    }
        
}
