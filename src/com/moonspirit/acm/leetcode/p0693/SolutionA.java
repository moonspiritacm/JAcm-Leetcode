package com.moonspirit.acm.leetcode.p0693;

/**
 * 逐位遍历。O(logn) O(1)
 */
class SolutionA {
    public boolean hasAlternatingBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int r = -1;
        while (n != 0) {
            int t = n & 1; // n % 2
            if (r == t) {  // (r ^ u) == 0
                return false;
            }
            r = t;
            n >>= 1;  // n /= 2
        }
        return true;
    }
}
