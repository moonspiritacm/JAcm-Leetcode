package com.moonspirit.acm.leetcode.p0540;

/**
 * 异或运算。O(n) O(1)
 * <p>
 * a^a=0、a^0=a
 */
class SolutionB {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || (nums.length & 1) == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
