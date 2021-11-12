package com.moonspirit.acm.leetcode.p0375;

class Solution {
    public int getMoneyAmount(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("非法输入");
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int k = 1; k < n; k++) {
            for(int i=1;i+k<=n;i++) {
                for(int j=i;j<=i+k;j++) {
                    dp[i][i+k]=Math.max(dp[])
                }
            }
        }
    }
}
