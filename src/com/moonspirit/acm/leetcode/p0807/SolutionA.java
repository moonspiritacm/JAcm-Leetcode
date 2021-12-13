package com.moonspirit.acm.leetcode.p0807;

/**
 * 贪心。O(mn) O(m+n)
 * <p>
 * 每个位置能调整到的最大高度为行/列高度的较小值。
 * 如果每个位置调整到最大高度（局部最优），最终可以使总的增加高度最大（全局最优）。
 */
class SolutionA {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[j] = Math.max(row[j], grid[i][j]);
                col[i] = Math.max(col[i], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(col[i], row[j]) - grid[i][j];
            }
        }
        return res;
    }
}
