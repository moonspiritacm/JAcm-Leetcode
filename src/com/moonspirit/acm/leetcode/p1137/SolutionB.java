package com.moonspirit.acm.leetcode.p1137;

/**
 * 存储空间优化。O(n) O(1)
 * <p>
 * 边界条件：F(0)=0、F(1)=1、F(2)=1
 * 状态转移方程：F(n)=F(n-1)+F(n-2)+F(n-3)
 */
class SolutionB {
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

        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i % 3] += dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }
}
