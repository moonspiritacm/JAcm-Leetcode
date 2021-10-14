package com.moonspirit.acm.leetcode.p0441;

/**
 * 一元二次方程。O(1) O(1)
 * <p>
 * 注意，整型溢出。
 */
class SolutionA {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }

        return (int) ((Math.sqrt(1.0 + 8.0 * n) - 1.0) / 2.0);
    }
}
