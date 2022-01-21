package com.moonspirit.acm.leetcode.p1220;

/**
 * 矩阵快速幂。O(logn) O(1)
 */
class SolutionC {
    public static final int MOD = (int) (1e9 + 7);

    /**
     * 矩阵乘法：A(m×r) * B(r×n) = C(m×n)
     *
     * @param a m行r列
     * @param b r行n列
     * @return m行n列
     */
    private long[][] mul(long[][] a, long[][] b) {
        int m = a.length;
        int r = a[0].length;
        int n = b[0].length;
        long[][] c = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < r; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }

    public int countVowelPermutation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        long[][] mx = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0}
        };  // 因子矩阵
        long[][] res = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };  // 单位矩阵
        n--;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = mul(res, mx);
            }
            mx = mul(mx, mx);
            n >>= 1;
        }

        long sum = 0;
        long[][] dp = new long[1][5];
        for (int j = 0; j < 5; j++) {
            dp[0][j] = 1;
        }
        dp = mul(dp, res);
        for (int j = 0; j < 5; j++) {
            sum += dp[0][j];
            sum %= MOD;
        }
        return (int) sum;
    }
}
