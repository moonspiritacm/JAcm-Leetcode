package com.moonspirit.acm.leetcode.p0326;

/**
 * 试除。O(logn) O(1)
 * <p>
 * n除以3，直到不能被3整除，最后判断n是否等于1（3^0）。
 */
class SolutionA {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
