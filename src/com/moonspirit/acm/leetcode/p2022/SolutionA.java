package com.moonspirit.acm.leetcode.p2022;

/**
 * 模拟。O(mn) O(1)
 */
class SolutionA {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length == 0 || m <= 0 || n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] res = new int[m][n];
        for (int i = 0, k = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[k++];
            }
        }
        return res;
    }
}
