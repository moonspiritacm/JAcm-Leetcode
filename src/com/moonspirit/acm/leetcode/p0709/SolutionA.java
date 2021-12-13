package com.moonspirit.acm.leetcode.p0709;

/**
 * 内置方法。O(n) O(1)
 */
class SolutionA {
    public String toLowerCase(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        return s.toLowerCase();
    }
}
