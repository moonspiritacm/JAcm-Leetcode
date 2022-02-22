package com.moonspirit.acm.leetcode.p1763;

class SolutionA {
    public String longestNiceSubstring(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = s.length();
        int max = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if (check(s, i, j) && j - i > max) {
                    res = s.substring(i, j);
                }
            }
        }
        return res;
    }

    private boolean check(String s, int i, int j) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        while (i < j) {
            char ch = s.charAt(i++);
            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A'] = true;
            }
        }
        for (int k = 0; k < 26; k++) {
            if (lower[k] != upper[k]) {
                return false;
            }
        }
        return true;
    }
}
