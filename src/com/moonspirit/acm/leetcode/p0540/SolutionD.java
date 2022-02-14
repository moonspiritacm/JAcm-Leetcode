package com.moonspirit.acm.leetcode.p0540;

/**
 * 二分查找（偶数下标）。O(logn) O(1)
 * <p>
 * 中间值既可能是奇数，也可能是偶数，在判断二段性时需要分别考虑。
 * 取不大于中间值的最大偶数下标（m -= m & 1），避免奇偶讨论和边界判断：
 * ①若中间偶数与后数相同，则单一元素必位于右侧（不包含），l=m+2；
 * ②若中间偶数与后数不同，则单一元素必位于左侧（包含），r=m。
 */
class SolutionD {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            m -= m & 1;
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[r];
    }
}
