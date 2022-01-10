package com.moonspirit.acm.leetcode.p0306;

class Solution {
    private boolean helper(String num, int index, String s1, String s2) {
        for (int i = i1, j = j1; i < i2 || j < j2; ) {

        }
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (num.length() < 3 || num.charAt(0) == '0') {
            return false;
        }

        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                continue;
            }
            String s1 = num.substring(0, i);
            for (int j = i + 1; j < n; j++) {
                String s2 = num.substring(i, j);
                if (helper(num, j, s1, s2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
