package com.moonspirit.acm.leetcode.p0006;

/**
 * 等差数列。O(n) O(1)
 * <p>
 * 首尾行：首项i，公差2(m-1)的一组等差数列；
 * 其他行：首项i和i+2(m-1-i)，公差2(m-1)的两组等差数列交替排列。
 */
class SolutionA {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int m = numRows;
        int n = s.length();
        int d = 2 * (m - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) {  // 一组等差数列
                int a = i;
                while (a < n) {
                    sb.append(s.charAt(a));
                    a += d;
                }
            } else {  // 两组等差数列
                int a1 = i;
                int a2 = i + 2 * (m - i - 1);
                while (a1 < n && a2 < n) {
                    sb.append(s.charAt(a1));
                    sb.append(s.charAt(a2));
                    a1 += d;
                    a2 += d;
                }
                if (a1 < n) {
                    sb.append(s.charAt(a1));
                }
            }
        }
        return sb.toString();
    }
}
