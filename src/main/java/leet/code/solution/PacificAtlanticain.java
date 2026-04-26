package leet.code.solution;


import java.util.*;

/**
 * 417. Pacific Atlantic Water Flow
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 * [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 * [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 * [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 * [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 * [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 * [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 * [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 * <p>
 * Example 2:
 * <p>
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */
public class PacificAtlanticain {

    public static void main(String[] args) {
        System.out.println(pacc(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    public static List<List<Integer>> pacc(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Position> queuePac = new LinkedList<>();
        Queue<Position> queueAtl = new LinkedList<>();
        Set<Position> visited = new HashSet<>();

        Set<Position> common = new HashSet<>();

        for (int i = 0; i < heights[0].length; i++) {
            queuePac.add(new Position(0, i));
        }
        for (int i = 0; i < heights.length; i++) {
            queuePac.add(new Position(i, 0));
        }
        for (int i = 0; i < heights[0].length; i++) {
            queueAtl.add(new Position(heights.length - 1, i));
        }
        for (int i = 0; i < heights.length; i++) {
            queueAtl.add(new Position(i, heights[0].length - 1));
        }
        while (!queuePac.isEmpty()) {
            Position poll = queuePac.poll();
            visited.add(poll);
            Queue<Position> positions = findAdj(heights, poll, visited);
            Position peek = positions.peek();
            if (positions.isEmpty() || heights[peek.row][peek.col] >= heights[poll.row][poll.col]) {
                common.add(poll);
            }
            queuePac.addAll(positions);
        }

        visited = new HashSet<>();
        while (!queueAtl.isEmpty()) {
            Position poll = queueAtl.poll();
            visited.add(poll);
            Queue<Position> positions = findAdj(heights, poll, visited);
            if (common.contains(poll)) {
                result.add(Arrays.asList(poll.row, poll.col));
                common.remove(poll);
            }
            queueAtl.addAll(positions);
        }
        return result;
    }

    private static Queue<Position> findAdj(int[][] heights, Position position, Set<Position> visited) {
        Queue<Position> queue = new LinkedList<>();
        int[][] newPost = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxRow = heights.length;
        int maxCol = heights[0].length;

        for (int[] ints : newPost) {
            int x = position.row + ints[0];
            int y = position.col + ints[1];

            if (x >= 0 && x < maxRow && y >= 0 && y < maxCol) {
                if (heights[x][y] >= heights[position.row][position.col] && !visited.contains(new Position(x, y))) {
                    queue.add(new Position(x, y));
                }
            }
        }

        return queue;
    }

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

}
