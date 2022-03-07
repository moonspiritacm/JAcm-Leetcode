package com.moonspirit.acm.leetcode.p0526;

/**
 * 状压动规。O(n^2*2^n) O(n*2^n)
 * <p>
 * 状压动规的输入规模一般不大，但状态相对复杂，使用二进制数存储状态，位运算加速状态转移。
 * <p>
 * 定义dp[i][state]表示考虑前i个数，当前数字选取状态为state的所有方案数量，f[0][0]=1。
 * state表示当前哪些数已被选，哪些数未被选，(state>>k)&1检查数字k是否被使用，总状态数2^n。
 * <p>
 * 所选数字满足填入条件：数字k满足整除要求，并且当前状态state的数字k已被使用。
 * 上一状态满足转移条件：上一状态state的数字k未被使用。
 */
class SolutionB {
    public int countArrangement(int n) {
        if (n < 1 || n > 15) {
            throw new IllegalArgumentException("非法输入");
        }

        int bound = 1 << n;  // 状态上界
        int[][] dp = new int[n + 1][bound];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {  // 遍历待填入位置
            for (int state = 0; state < bound; state++) {  // 遍历数字选取状态
                for (int k = 1; k <= n; k++) {  // 遍历待填入数字
                    if (((state >> (k - 1)) & 1) == 0) {
                        continue;
                    }
                    if (k % i != 0 && i % k != 0) {
                        continue;
                    }
                    dp[i][state] += dp[i - 1][state & (~(1 << (k - 1)))];
                }
            }
        }
        return dp[n][bound - 1];
    }
}
