package com.moonspirit.acm.leetcode.p1137;

/**
 * 动态规划。O(n) O(n)
 * <p>
 * 边界条件：f(0)=0、f(1)=1、f(2)=1
 * 状态转移方程：f(n)=f(n-1)+f(n-2)+f(n-3)
 */
class SolutionA {
    public int tribonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
