package com.moonspirit.acm.leetcode.p0070;

/**
 * 动态规划。O(n) O(n)
 * <p>
 * 边界条件：f(0)=1、f(1)=1
 * 状态转移方程：f(n)=f(n-1)+f(n-2)
 */
class SolutionA {
    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (n < 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
