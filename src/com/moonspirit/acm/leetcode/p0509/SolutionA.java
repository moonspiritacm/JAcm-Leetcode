package com.moonspirit.acm.leetcode.p0509;

/**
 * 动态规划。O(n) O(n)
 * <p>
 * 边界条件：F(0)=0、F(1)=1
 * 状态转移方程：F(n)=F(n-1)+F(n-2)
 */
class SolutionA {
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
