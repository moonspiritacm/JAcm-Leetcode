package com.moonspirit.acm.leetcode.p0326;

/**
 * 约数。O(1) O(1)
 * <p>
 * int范围内的最大3次幂为3^19=1162261467，n为3的幂当且仅当n能整除1162261467。
 */
class SolutionB {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        return 1162261467 % n == 0;
    }
}
