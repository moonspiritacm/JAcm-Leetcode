package com.moonspirit.acm.leetcode.p1614;

/**
 * 栈。O(n) O(1)
 */
class SolutionA {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int num = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                num++;
                max = Math.max(max, num);
            } else if (ch == ')') {
                num--;
            }
        }
        return max;
    }
}
