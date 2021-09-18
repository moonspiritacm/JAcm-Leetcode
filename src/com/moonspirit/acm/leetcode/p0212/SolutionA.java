package com.moonspirit.acm.leetcode.p0212;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean dfs(char[][] board, char[] chs, boolean[][] vis, int[][] dict, int i, int j, int idx) {
        if (idx == chs.length) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int ii = i + dict[k][0];
            int jj = j + dict[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && !vis[ii][jj] && board[ii][jj] == chs[idx]) {
                vis[ii][jj] = true;
                if (dfs(board, chs, vis, dict, ii, jj, idx + 1)) {
                    return true;
                }
                vis[ii][jj] = false;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return word == null || word.length() == 0;
        }

        int m = board.length;
        int n = board[0].length;
        char[] chs = word.toCharArray();
        boolean[][] vis = new boolean[m][n];
        int[][] dict = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    vis[i][j] = true;
                    if (dfs(board, chs, vis, dict, i, j, 1)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
}
