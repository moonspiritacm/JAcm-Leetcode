package com.moonspirit.acm.leetcode.p0540;

/**
 * 暴力搜索。O(n) O(1)
 * <p>
 * 以步长为2遍历，找到第一个与后数不相等的元素，即为答案。
 */
class SolutionA {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = nums.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[n - 1];
    }
}
