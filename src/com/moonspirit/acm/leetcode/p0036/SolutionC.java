package com.moonspirit.acm.leetcode.p0036;

/**
 * 位运算。O(1) O(1)
 * <p>
 * 对于n×n棋盘，时间复杂度O(n^2)，空间复杂度O(n)。
 */
class SolutionC {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        int[] row = new int[9];
        int[] col = new int[9];
        int[] sqr = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    int x = i / 3 * 3 + j / 3;
                    if ((row[i] >> k & 1) == 1 || (col[j] >> k & 1) == 1 || (sqr[x] >> k & 1) == 1) {
                        return false;
                    }
                    row[i] |= 1 << k;
                    col[j] |= 1 << k;
                    sqr[x] |= 1 << k;
                }
            }
        }
        return true;
    }
}
