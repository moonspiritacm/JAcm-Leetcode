package com.moonspirit.acm.leetcode.p0375;

class SolutionA {
    private int[][] dp;

    private int dfs(int l, int r) {
        if (r - l <= 0) { // 只有一个数，无须选择
            return 0;
        }
        if (r - l == 1) { // 只有两个数，选较小者
            return l;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        dp[l][r] = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int sum = i + Math.max(dfs(l, i - 1), dfs(i + 1, r));
            dp[l][r] = Math.min(dp[l][r], sum);
        }
        return dp[l][r];
    }

    public int getMoneyAmount(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("非法输入");
        }

        dp = new int[n + 1][n + 1];
        return dfs(1, n);
    }
}
