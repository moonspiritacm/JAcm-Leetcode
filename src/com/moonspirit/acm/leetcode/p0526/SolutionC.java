package com.moonspirit.acm.leetcode.p0526;

/**
 * 状态压缩动态规划。O(n2^n) O(2^n)
 * <p>
 * 依序填入每次都需要遍历所有状态，其中很多状态已不满足填入条件，造成无效访问。
 * 不按照顺序填入，而是按照数值状态进行转移。
 * <p>
 * 定义dp[state]为数值状态state的所有方案数量，dp[0]=1，dp[(1<<n)-1]即为所求。
 */
class SolutionC {
    private int getCount(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public int countArrangement(int n) {
        if (n < 1 || n > 15) {
            throw new IllegalArgumentException("非法输入");
        }

        int bound = 1 << n;  // 状态上界
        int[] dp = new int[bound];
        dp[0] = 1;
        for (int state = 1; state < bound; state++) {
            int i = getCount(state);  // 待填入位置
            for (int k = 1; k <= n; k++) {
                if (((state >> (k - 1)) & 1) == 0) {
                    continue;
                }
                if (k % i != 0 && i % k != 0) {
                    continue;
                }
                dp[state] += dp[state & (~(1 << (k - 1)))];
            }
        }
        return dp[bound - 1];
    }
}
