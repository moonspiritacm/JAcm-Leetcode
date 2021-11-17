package com.moonspirit.acm.leetcode.p0165;

/**
 * 模拟。O(max(m,n)) O(m+n)
 */
class SolutionA {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int i1 = 0;
        int i2 = 0;
        int n1 = version1.length();
        int n2 = version2.length();
        char[] ch1 = version1.toCharArray();
        char[] ch2 = version2.toCharArray();
        while (i1 < n1 || i2 < n2) {
            int v1 = 0;
            int v2 = 0;
            while (i1 < n1 && ch1[i1] != '.') {
                v1 *= 10;
                v1 += ch1[i1++] - '0';
            }
            while (i2 < n2 && ch2[i2] != '.') {
                v2 *= 10;
                v2 += ch2[i2++] - '0';
            }
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
            i1++;
            i2++;
        }
        return 0;
    }
}
