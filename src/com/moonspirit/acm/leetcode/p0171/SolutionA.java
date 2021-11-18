package com.moonspirit.acm.leetcode.p0171;

/**
 * 进制转换。O(n) O(n)
 */
class SolutionA {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int res = 0;
        for (char ch : columnTitle.toCharArray()) {
            res *= 26;
            res += ch - 'A' + 1;
        }
        return res;
    }
}
