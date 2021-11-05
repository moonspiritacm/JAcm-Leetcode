package com.moonspirit.acm.leetcode.p0912;

/**
 * 选择排序。O(n^2) O(1)
 */
class SolutionA {
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
        return nums;
    }
}
