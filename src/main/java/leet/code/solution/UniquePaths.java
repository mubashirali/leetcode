package leet.code.solution;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * <p>
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 */
public class UniquePaths {
    /**
     * Runtime: 0 ms
     * Memory Usage: 35.9 MB
     */
    public static int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];

        for (int i = 0; i < path.length; i++) {
            path[i][0] = 1;
        }

        Arrays.fill(path[0], 1);

        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[i].length; j++) {
                path[i][j] = path[i][j - 1] + path[i - 1][j];
            }

        }

        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}
