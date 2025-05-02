package leet.code;

public class MinPathSum {

    /**
     * https://leetcode.com/problems/minimum-path-sum/description/
     * 64. Minimum Path Sum
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * <p>
     * Example 2:
     * <p>
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     */
    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int sum = 0;
                if (i > 0 && j > 0) {
                    sum = Math.min(grid[i][j - 1], grid[i - 1][j]);
                } else if (i > 0) {
                    sum = grid[i - 1][j];
                } else if (j > 0) {
                    sum = grid[i][j - 1];
                }
                grid[i][j] += sum;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
