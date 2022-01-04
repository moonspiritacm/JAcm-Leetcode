package com.moonspirit.acm.leetcode.p0825;

/**
 * 暴力搜索（超时）。O(n^2) O(1)
 */
class SolutionA {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if (i == j || ages[j] > ages[i] || ages[j] <= 0.5 * ages[i] + 7 || ages[j] > 100 && ages[i] < 100) {
                    continue;
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}
