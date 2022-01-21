package com.moonspirit.acm.leetcode.p1220;

/**
 * 动态规划。O(n) O(n)
 */
class SolutionA {
    public static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        long[][] dp = new long[n][5];
        for (int j = 0; j < 5; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            // 'a'前面只能跟着'e'、'i'、'u'
            dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4];
            // 'e'前面只能跟着'a'、'i'
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            // 'i'前面只能跟着'e'、'o'
            dp[i][2] = dp[i - 1][1] + dp[i - 1][3];
            // 'o'前面只能跟着'i'
            dp[i][3] = dp[i - 1][2];
            // 'u'前面只能跟着'i'、'o'
            dp[i][4] = dp[i - 1][2] + dp[i - 1][3];
            for (int j = 0; j < 5; j++) {
                dp[i][j] %= MOD;
            }
        }
        long res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[n - 1][j];
            res %= MOD;
        }
        return (int) res;
    }
}
