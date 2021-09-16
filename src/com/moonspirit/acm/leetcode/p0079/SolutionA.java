package com.moonspirit.acm.leetcode.p0079;

/**
 * 回溯。O(mn3^L) O(min(L,mn))
 */
class SolutionA {
    private boolean dfs(char[][] board, char[] chs, int[][] dict, int idx, int i, int j) {
        if (idx == chs.length) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int ii = i + dict[k][0];
            int jj = j + dict[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && board[ii][jj] == chs[idx]) {
                board[ii][jj] = '.';
                if (dfs(board, chs, dict, idx + 1, ii, jj)) {
                    return true;
                }
                board[ii][jj] = chs[idx];
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        char[] chs = word.toCharArray();
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    board[i][j] = '.';
                    if (dfs(board, chs, dict, 1, i, j)) {
                        return true;
                    }
                    board[i][j] = chs[0];
                }
            }
        }
        return false;
    }
}
