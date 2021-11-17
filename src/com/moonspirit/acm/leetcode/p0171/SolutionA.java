package com.moonspirit.acm.leetcode.p0171;

/**
 * 进制转换。O(n) O(n)
 */
class SolutionA {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int num = 0;
        char[] chs = columnTitle.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            num *= 26;
            num += chs[i] - 'A' + 1;
        }
        return num;
    }
}
