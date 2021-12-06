package com.moonspirit.acm.leetcode.p0070;

/**
 * 记忆化递归。O(n) O(n)
 * <p>
 * 边界条件：f(0)=0、f(1)=1
 * 状态转移方程：f(n)=f(n-1)+f(n-2)
 */
class SolutionC {
    private int[] dp;

    private int helper(int n) {
        if (n < 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(n - 1) + helper(n - 2);
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        dp = new int[n + 1];
        return helper(n);
    }
}
