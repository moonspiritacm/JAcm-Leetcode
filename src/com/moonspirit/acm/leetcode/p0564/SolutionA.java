package com.moonspirit.acm.leetcode.p0564;

class SolutionA {
    public String nearestPalindromic(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int l
        if (s.length() == 1 || "10".equals(s)) {
            return String.valueOf(Integer.valueOf(s) - 1);
        }

        int m = s.length();
        int l = m / 2;
        int r = m / 2;
        if (s.length() % 2 == 0) {
            l = r - 1;
        }
        char[] cs = s.toCharArray();
        while (l >= 0) {
            if (s.charAt(l) != s.charAt(r)) {
                cs[r] = cs[l];
            }
            l--;
            r++;
        }
        return new String(cs);
    }
}
