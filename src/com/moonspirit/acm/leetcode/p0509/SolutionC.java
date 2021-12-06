package com.moonspirit.acm.leetcode.p0509;

/**
 * 记忆化递归。O(n) O(n)
 * <p>
 * 边界条件：F(0)=0、F(1)=1
 * 状态转移方程：F(n)=F(n-1)+F(n-2)
 */
class SolutionC {
    private int[] dp;

    private int helper(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(n - 1) + helper(n - 2);
        return dp[n];
    }

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }

        dp = new int[n + 1];
        return helper(n);
    }
}
