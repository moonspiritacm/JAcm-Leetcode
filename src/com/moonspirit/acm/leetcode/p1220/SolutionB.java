package com.moonspirit.acm.leetcode.p1220;

/**
 * 滚动数组。O(n) O(1)
 */
class SolutionB {
    public static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        long[][] dp = new long[2][5];
        for (int j = 0; j < 5; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            // 'a'前面只能跟着'e'、'i'、'u'
            dp[i % 2][0] = dp[(i - 1) % 2][1] + dp[(i - 1) % 2][2] + dp[(i - 1) % 2][4];
            // 'e'前面只能跟着'a'、'i'
            dp[i % 2][1] = dp[(i - 1) % 2][0] + dp[(i - 1) % 2][2];
            // 'i'前面只能跟着'e'、'o'
            dp[i % 2][2] = dp[(i - 1) % 2][1] + dp[(i - 1) % 2][3];
            // 'o'前面只能跟着'i'
            dp[i % 2][3] = dp[(i - 1) % 2][2];
            // 'u'前面只能跟着'i'、'o'
            dp[i % 2][4] = dp[(i - 1) % 2][2] + dp[(i - 1) % 2][3];
            for (int j = 0; j < 5; j++) {
                dp[i % 2][j] %= MOD;
            }
        }
        long res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[(n - 1) % 2][j];
            res %= MOD;
        }
        return (int) res;
    }
}
