package com.moonspirit.acm.leetcode.p0037;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯。O(1) O(1)
 * <p>
 * 对于n×n棋盘，最坏情况是没有预填元素，即最多有n×n个空白格子。每个格子有n种填法，时间复杂度O(n^3)，空间复杂度O(n^2)。
 */
class SolutionB {
    private boolean[][] row;
    private boolean[][] col;
    private boolean[][][] sqr;
    private List<Integer> todo;

    private boolean backtrace(char[][] board, int idx) {
        if (idx == todo.size()) {
            return true;
        }

        int x = todo.get(idx);
        int i = x / 9;
        int j = x % 9;
        if (board[i][j] != '.') {
            return backtrace(board, idx + 1);
        }
        for (int k = 0; k < 9; k++) {
            if (!row[i][k] && !col[j][k] && !sqr[i / 3][j / 3][k]) {
                board[i][j] = (char) ('1' + k);
                row[i][k] = col[j][k] = sqr[i / 3][j / 3][k] = true;
                if (backtrace(board, idx + 1)) {
                    return true;
                }
                row[i][k] = col[j][k] = sqr[i / 3][j / 3][k] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }

        row = new boolean[9][9];
        col = new boolean[9][9];
        sqr = new boolean[3][3][9];
        todo = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    row[i][k] = col[j][k] = sqr[i / 3][j / 3][k] = true;
                } else {
                    todo.add(i * 9 + j);
                }
            }
        }
        backtrace(board, 0);
    }
}
