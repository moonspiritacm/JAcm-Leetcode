package com.moonspirit.acm.leetcode.p0912;

class SolutionB {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        boolean flag = true;
        for (int i = 0; i < n - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }
}
