package com.moonspirit.acm.leetcode.p0036;

/**
 * 编程练习。O(1) O(1)
 * <p>
 * 对于n×n棋盘，时间复杂度O(n^2)，空间复杂度O(n^2)。
 */
class SolutionA {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] sqr = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    if (row[i][k] || col[j][k] || sqr[i / 3][j / 3][k]) {
                        return false;
                    }
                    row[i][k] = col[j][k] = sqr[i / 3][j / 3][k] = true;
                }
            }
        }
        return true;
    }
}
