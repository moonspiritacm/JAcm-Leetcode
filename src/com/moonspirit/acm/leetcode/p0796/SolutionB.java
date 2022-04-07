package com.moonspirit.acm.leetcode.p0796;

/**
 * 模拟匹配。O(n^2) O(1)
 * <p>
 * 假设s旋转i位，则goal[j]应与s[(i+j)&n]相等。
 */
class SolutionB {
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
