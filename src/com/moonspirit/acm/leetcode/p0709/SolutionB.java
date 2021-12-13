package com.moonspirit.acm.leetcode.p0709;

/**
 * 手动模拟。O(n) O(1)
 */
class SolutionB {
    public String toLowerCase(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch -= 'A' - 'a';
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
