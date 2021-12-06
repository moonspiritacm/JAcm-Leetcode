package com.moonspirit.acm.leetcode.p1137;

/**
 * 记忆化递归。O(n) O(n)
 * <p>
 * 边界条件：F(0)=0、F(1)=1、F(2)=1
 * 状态转移方程：F(n)=F(n-1)+F(n-2)+F(n-3)
 */
class SolutionC {
    private int[] dp;

    private int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(n - 1) + helper(n - 2) + helper(n - 3);
        return dp[n];
    }

    public int tribonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }

        dp = new int[n + 1];
        return helper(n);
    }
}
