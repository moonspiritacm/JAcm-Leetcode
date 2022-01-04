package com.moonspirit.acm.leetcode.p0909;

/**
 * 深度优先搜索。
 */
class SolutionA {
    private int res;
    private int num;
    private int[] graph;

    private void dfs(int[][] board, int pos, int ans) {
        if (ans >= res) {
            return;
        }
        if (pos == num) {
            res = ans;
            return;
        }

        for (int k = pos + 1; k <= pos + 6 && k <= num; k++) {
            if (graph[k] == -1) {
                dfs(board, k, ans + 1);
            } else {
                dfs(board, graph[k], ans + 1);
            }
        }
    }

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = board.length;
        graph = new int[n * n + 1];
        res = n * n;
        num = n * n;
        for (int i = n - 1, k = 1; i >= 0; i--) {
            if (i % 2 != n % 2) {
                for (int j = 0; j < n; j++) {
                    graph[k++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    graph[k++] = board[i][j];
                }
            }
        }

        dfs(board, 1, 0);
        return res == num ? -1 : res;
    }
}
