package com.moonspirit.acm.leetcode.p1995;

/**
 * 暴力搜索。O(n^4) O(1)
 */
class SolutionA {
    public int countQuadruplets(int[] nums) {
        if (nums == null || nums.length < 4) {
            throw new IllegalArgumentException("非法输入");
        }

        int res = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
