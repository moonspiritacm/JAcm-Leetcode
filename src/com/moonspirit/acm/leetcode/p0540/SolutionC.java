package com.moonspirit.acm.leetcode.p0540;

/**
 * 二分查找。O(logn) O(1)
 * <p>
 * 成对元素中的第一个对应的下标必然是偶数，成对元素中的第二个对应的下标必然是奇数。
 * <p>
 * 规律失效是前段插入单一元素导致的，由此产生二段性：
 * ①若规律成立，则插入位置位于右侧（不包含），l=m+1;
 * ②若规律失效，则插入位置位于左侧（包含），r=m。
 * <p>
 * m向下取整（偏左），r可能原地不动，不会出现死循环。
 */
class SolutionC {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 0) {  // 偶数位应与后数相同
                if (m == nums.length - 1 || nums[m] != nums[m + 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {  // 奇数位应与前数相同
                if (m == 0 || nums[m] != nums[m - 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return nums[r];
    }
}
