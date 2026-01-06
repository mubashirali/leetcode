package leet.code.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
     * 102. Binary Tree Level Order Traversal
     * Solved
     * Medium
     * Topics
     * premium lock iconCompanies
     * Hint
     *
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     *
     * Example 2:
     *
     * Input: root = [1]
     * Output: [[1]]
     *
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [0, 2000].
     *     -1000 <= Node.val <= 1000
     * @param args
     */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list; 
        }

        order(root, list, 0);
        return list;
    }

    public void order(TreeNode root, List<List<Integer>> list, int level){
        if(root == null){
            return;
        }
        List<Integer> temp;
        if(list.size() > level)
        { 
            temp = list.get(level);
            temp.add(root.val);
             
        }else{
            temp = new ArrayList<>();
            temp.add(root.val);
            list.add(temp);
        }


        order(root.left, list, level + 1);
        order(root.right, list, level + 1);
    }
}
