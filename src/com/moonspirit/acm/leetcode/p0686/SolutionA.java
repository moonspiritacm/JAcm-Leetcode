package com.moonspirit.acm.leetcode.p0686;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n1 = a.length();
        int n2 = b.length();
        int[] d1 = new int[26];
        int[] d2 = new int[26];
        for (int i = 0; i < n1; i++) {
            d1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n2; i++) {
            d2[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (d2[i] > 0 && d1[i] == 0) {
                return -1;
            }
        }

        int res = 0;
        int index = 0;
        while (index < n2) {

        }
        while (index < n2) {
            int i = 0;
            while (i < n1 && index < n2) {
                if (a.charAt(i) != b.charAt(index)) {
                    System.out.printf("%d %d %d %d\n", i, index, a.charAt(i), b.charAt(index));
                    return -1;
                }
                i++;
                index++;
            }
            res++;
        }
        return res;
    }
}
