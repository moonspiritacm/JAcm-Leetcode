package com.moonspirit.acm.leetcode.p0746;

/**
 * 动态规划。O(n) O(n)
 * <p>
 * 状态定义：f(i)表示到达下标i的最小花费，f(n)即为到达楼顶的最小花费，阶梯编号0到n-1，楼顶下标为n。
 * 边界条件：可以选择下标0或1为初始位置，f(0)=0、f(1)=0。
 * 状态转移方程：f(i)=min(f(i-1)+cost[i-1], f(i-2)+cost[i-2])
 */
class SolutionA {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
