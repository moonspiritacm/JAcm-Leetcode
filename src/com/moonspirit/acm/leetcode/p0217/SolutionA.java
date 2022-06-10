package com.moonspirit.acm.leetcode.p0217;

import java.util.Arrays;

/**
 * 排序。O(nlogn) O(logn)
 *
 * 重复元素一定出现在有序数组的相邻位置，每次判断相邻元素是否相等，即可发现
 */
class SolutionA {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
