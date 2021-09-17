package com.moonspirit.acm.leetcode.p0036;

/**
 * 编程练习。O(1) O(1)
 * <p>
 * 对于n×n棋盘，时间复杂度O(n^2)，空间复杂度O(n^2)。
 * <p>
 * 大多数哈希表计数问题，都能转换为使用数组解决，使用位运算可以进一步降低空间复杂度。
 * 虽然时间复杂度一样，但哈希表更新和查询复杂度为均摊O(1)，定长数组的更新和查询复杂度为严格O(1)，因此，数组优于哈希表。
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
