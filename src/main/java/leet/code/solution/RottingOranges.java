package leet.code.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * Example 1:
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * <p>
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]
                {{2, 2, 2, 1, 1}}));

    }

    /**
     * @see leet.code.solution.ZombieInMatrix
     * Runtime: 10 ms
     * Memory Usage: 43.2 MB
     */
    public static int orangesRotting(int[][] grid) {
        int count = 0;
        int result = 0;
        int target = grid.length * grid[0].length;

        Queue<Matrix> adjMatrix = new LinkedList<>();
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[j].length; k++) {
                if (grid[j][k] == 2) {
                    adjMatrix.addAll(getAdjMatrix(grid, j, k));
                    count++;
                }
            }
        }

        while (!adjMatrix.isEmpty()) {
            final int size = adjMatrix.size();
            if (target == count) {
                break;
            }
            for (int i = 0; i < size; i++) {
                final Matrix matrix = adjMatrix.poll();
                final Queue<Matrix> queue = getAdjMatrix(grid, matrix.row, matrix.col);
                adjMatrix.addAll(queue);
                while (!queue.isEmpty()) {
                    final Matrix poll = queue.poll();
                    grid[poll.row][poll.col] = 2;
                    count++;
                }
            }
            result++;
        }

        for (int[] rows : grid) {
            for (int cols : rows) {
                if (cols == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    private static Queue<Matrix> getAdjMatrix(int[][] grid, int rows, int columns) {
        Queue<Matrix> adjMatrix = new LinkedList<>();

        if (rows > 0 && grid[rows - 1][columns] == 1) {
            adjMatrix.add(new Matrix(rows - 1, columns));
        }
        if (rows < grid.length - 1 && grid[rows + 1][columns] == 1) {
            adjMatrix.add(new Matrix(rows + 1, columns));
        }
        if (columns < grid[rows].length - 1 && grid[rows][columns + 1] == 1) {
            adjMatrix.add(new Matrix(rows, columns + 1));
        }
        if (columns > 0 && grid[rows][columns - 1] == 1) {
            adjMatrix.add(new Matrix(rows, columns - 1));
        }

        return adjMatrix;
    }

    private static class Matrix {
        private int row;
        private int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
