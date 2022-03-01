package com.moonspirit.acm.leetcode.p0006;

/**
 * 等差数列。O(n) O(1)
 * <p>
 * 首尾行：首项i，公差2(m-1)的一组等差数列；
 * 其他行：首项i和i+2(m-1-i)，公差2(m-1)的两组等差数列交替排列。
 */
class SolutionA {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int n = s.length();
        int m = numRows;
        int offset = 2 * (m - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) { // 一组等差数列
                int j = i;
                while (j < n) {
                    sb.append(s.charAt(j));
                    j += offset;
                }
            } else { // 两组等差数列
                int j1 = i;
                int j2 = i + 2 * (m - 1 - i);
                while (j1 < n && j2 < n) {
                    sb.append(s.charAt(j1));
                    sb.append(s.charAt(j2));
                    j1 += offset;
                    j2 += offset;
                }
                if (j1 < n) {
                    sb.append(s.charAt(j1));
                }
            }
        }
        return sb.toString();
    }
}
