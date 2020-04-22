package leet.code.solution;

import java.util.Stack;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        Stack<Position> stack = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[board.length][board[i].length];
                    visited[i][j] = 1;
                    stack.add(new Position(i, j, 0, word.substring(0, 1), visited));
                }
            }
        }
        while (!stack.isEmpty()) {
            final Position position = stack.pop();

            if (position.charIndex + 1 < word.length()) {
                stack.addAll(getAdjMatrix(board, position, word));
            } else if (position.charIndex == word.length() - 1 && word.equals(position.word)) {
                return true;
            }
        }
        return false;
    }

    private static Stack<Position> getAdjMatrix(char[][] board, Position position, String word) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Stack<Position> stack = new Stack<>();

        for (int[] ints : dir) {
            int x = position.row + ints[0];
            int y = position.col + ints[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length &&
                    word.charAt(position.charIndex + 1) == board[x][y] && position.visited[x][y] == 0) {
                position.visited[x][y] = 1;
                stack.add(new Position(x, y, position.charIndex + 1,
                        word.substring(0, position.charIndex + 2), position.visited));
            }
        }
        return stack;
    }

    static class Position {
        String word;
        int row;
        int col;
        int charIndex;
        int[][] visited;

        public Position(int row, int col, int charIndex, String word, int[][] visited) {
            this.row = row;
            this.col = col;
            this.charIndex = charIndex;
            this.word = word;
            this.visited = visited;
        }
    }
}
