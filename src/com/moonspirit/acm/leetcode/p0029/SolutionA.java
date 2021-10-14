package com.moonspirit.acm.leetcode.p0029;

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        boolean sign = true;
        long ldividend = dividend;
        long ldivisor = divisor;
        if (ldividend < 0) {
            ldividend = -ldividend;
            sign = !sign;
        }
        if (ldivisor < 0) {
            ldivisor = -ldivisor;
            sign = !sign;
        }

        long res = 0;
        while (ldividend >= ldivisor) {
            ldividend -= ldivisor;
            res++;
        }
        if (!sign) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
