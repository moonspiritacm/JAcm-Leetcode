package com.moonspirit.acm.leetcode.p0509;

/**
 * 存储空间优化。O(n) O(1)
 * <p>
 * 边界条件：f(0)=0、f(1)=1
 * 状态转移方程：f(n)=f(n-1)+f(n-2)
 */
class SolutionB {
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (n < 2) {
            return n;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 2] += dp[(i - 1) % 2];
        }
        return dp[n % 2];
    }
}
