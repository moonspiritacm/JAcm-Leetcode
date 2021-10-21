package com.moonspirit.acm.leetcode.p0087;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        if (!check(s1, s2)) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String s1l = s1.substring(0, i);
            String s1r = s1.substring(i);
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        int[] cnt = new int[26];
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt[cs1[i] - 'a']++;
            cnt[cs2[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
