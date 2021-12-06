package com.moonspirit.acm.leetcode.p0746;

/**
 * 记忆化递归。O(n) O(1)
 * <p>
 * 状态定义：f(i)表示到达下标i的最小花费，f(n)即为到达楼顶的最小花费，阶梯编号0到n-1，楼顶下标为n。
 * 边界条件：可以选择下标0或1为初始位置，f(0)=0、f(1)=0。
 * 状态转移方程：f(i)=min(f(i-1)+cost[i-1], f(i-2)+cost[i-2])
 */
class SolutionC {
    private int[] dp;

    private int helper(int n, int[] cost) {
        if (n < 2) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = Math.min(helper(n - 1, cost) + cost[n - 1], helper(n - 2, cost) + cost[n - 2]);
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int n = cost.length;
        dp = new int[n + 1];
        return helper(n, cost);
    }
}
