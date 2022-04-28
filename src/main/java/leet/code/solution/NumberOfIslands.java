package leet.code.solution;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {

        System.out.println(numIslands(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                })
        );
    }

    /**
     * Runtime: 13 ms
     * Memory Usage: 43.1 MB
     */
    public static int numIslands(char[][] grid) {
        Stack<Position> once = new Stack<>();
        Set<Position> visited = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    once.push(new Position(i, j));
                }
            }
        }
        while (!once.isEmpty()) {
            final Position position = once.pop();
            if (!visited.contains(position)) {
                counter++;
                Stack<Position> stack = addEdges(grid, position, visited);
                while (!stack.isEmpty()) {
                    final Position newPosition = stack.pop();
                    stack.addAll(addEdges(grid, newPosition, visited));
                }
            }
        }

        return counter;
    }

    private static Stack<Position> addEdges(char[][] grid, Position position, Set<Position> visited) {
        Stack<Position> stack = new Stack<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = position.row + dir[0];
            int y = position.col + dir[1];
            final Position newPosition = new Position(x, y);
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length
                    && grid[x][y] == '1' && !visited.contains(newPosition)) {
                stack.push(newPosition);
                visited.add(newPosition);
            }
        }
        return stack;
    }
    
    public static int numIslands2ndSolution(char[][] grid) {
        int count = 0;
        Deque<Position> stack = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    stack.push(new Position(i, j));
                    grid[i][j] = 'x';
                    checkIsland(grid, stack);
                    count++;
                }
            }
        }

        return count;
    }
    
    private static void checkIsland(char[][] grid, Deque<Position> stack) {
        while (!stack.isEmpty()) {
            Position position = stack.pop();
            int row = position.row;
            int col = position.col;

            if (col < grid[row].length - 1 && grid[row][col + 1] == '1') {
                stack.push(new Position(row, col + 1));
                grid[row][col + 1] = 'x';
            }
            if (row < grid.length - 1 && grid[row + 1][col] == '1') {
                stack.push(new Position(row + 1, col));
                grid[row + 1][col] = 'x';
            }
            if (col > 0  && grid[row][col - 1] == '1') {
                stack.push(new Position(row, col - 1));
                grid[row][col - 1] = 'x';
            }
            if (row > 0  && grid[row - 1][col] == '1') {
                stack.push(new Position(row - 1, col));
                grid[row - 1][col] = 'x';
            }
        }

    }


    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
