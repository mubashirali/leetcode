package leet.code.solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
 * Find out how many hours does it take to infect all humans?
 */
public class ZombieInMatrix {

    public static void main(String[] args) {
        System.out.println(minHoursUsingBFS(asList(
                asList(0, 1, 1, 0, 1),
                asList(0, 1, 0, 1, 0),
                asList(0, 0, 0, 0, 1),
                asList(0, 1, 0, 0, 0))));

        System.out.println(
                minHoursUsingBFS(asList(
                        asList(1, 0, 0, 0),
                        asList(0, 1, 0, 1),
                        asList(0, 0, 0, 0),
                        asList(0, 0, 0, 0))
                ));

        System.out.println("With brute force");
        System.out.println(minHours(asList(
                asList(0, 1, 1, 0, 1),
                asList(0, 1, 0, 1, 0),
                asList(0, 0, 0, 0, 1),
                asList(0, 1, 0, 0, 0))));
        System.out.println(
                minHours(asList(
                        asList(1, 0, 0, 0),
                        asList(0, 1, 0, 1),
                        asList(0, 0, 0, 0),
                        asList(0, 0, 0, 0))));

    }

    /**
     * Complexity O(n2)
     *
     * @param grid
     * @return
     */
    private static int minHoursUsingBFS(List<List<Integer>> grid) {
        int count = 0;
        int result = 0;
        int target = grid.size() * grid.get(0).size();
        final Queue<Matrix> adjMatrix = new LinkedList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    adjMatrix.add(new Matrix(i, j));
                    count++;
                }
            }
        }

        while (!adjMatrix.isEmpty()) {
            if (target == count) {
                break;
            }
            final int size = adjMatrix.size();
            for (int i = 0; i < size; i++) {
                final Matrix matrix = adjMatrix.poll();
                final Queue<Matrix> queue = getAdjMatrix(grid, matrix.row, matrix.col);
                adjMatrix.addAll(queue);
                while (!queue.isEmpty()) {
                    final Matrix poll = queue.poll();
                    grid.get(poll.row).set(poll.col, 1);
                    count++;
                }
            }

            result++;
        }

        //Returning -1 in case all humans are not infect.
        for (List<Integer> rows : grid) {
            for (int j = 0; j < rows.size(); j++) {
                if (rows.get(j) == 0) {
                    return -1;
                }
            }
        }

        return result;
    }

    /**
     * Complexity O(n3)
     *
     * @param grid
     * @return
     */
    private static int minHours(List<List<Integer>> grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            Queue<Matrix> adjMatrix = new LinkedList<>();
            for (int j = 0; j < grid.size(); j++) {
                for (int k = 0; k < grid.get(j).size(); k++) {
                    if (grid.get(j).get(k) == 1) {
                        adjMatrix.addAll(getAdjMatrix(grid, j, k));
                    }
                }
            }
            if (!adjMatrix.isEmpty()) {
                count++;
            }
            while (!adjMatrix.isEmpty()) {
                final Matrix matrix = adjMatrix.poll();
                grid.get(matrix.row).set(matrix.col, 1);
            }
        }

        //Returning -1 in case all humans are not infect.
        for (List<Integer> rows : grid) {
            for (int j = 0; j < rows.size(); j++) {
                if (rows.get(j) == 0) {
                    return -1;
                }
            }
        }

        return count;
    }

    private static Queue<Matrix> getAdjMatrix(List<List<Integer>> grid, int rows, int columns) {
        Queue<Matrix> adjMatrix = new LinkedList<>();

        if (rows > 0 && grid.get(rows - 1).get(columns) == 0) {
            adjMatrix.add(new Matrix(rows - 1, columns));
        }
        if (rows < grid.size() - 1 && grid.get(rows + 1).get(columns) == 0) {
            adjMatrix.add(new Matrix(rows + 1, columns));
        }
        if (columns < grid.get(rows).size() - 1 && grid.get(rows).get(columns + 1) == 0) {
            adjMatrix.add(new Matrix(rows, columns + 1));
        }
        if (columns > 0 && grid.get(rows).get(columns - 1) == 0) {
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
