package com.moonspirit.acm.leetcode.p0179;

import java.util.Arrays;

/**
 * 贪心。O(n^2) O(n)
 * <p>
 * 自定义排列顺序，不能使用基本类型，应该使用其对应的包装类型。
 */

class SolutionA {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(nums);

        Arrays.sort(numsArr, (a, b) -> {
            String s1 = "" + a + b;
            String s2 = "" + b + a;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : numsArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}

/**
 * class Solution {
 * public String largestNumber(int[] nums) {
 * Arrays.sort(numsArr, (x, y) -> {
 * long sx = 10, sy = 10;
 * while (sx <= x) {
 * sx *= 10;
 * }
 * while (sy <= y) {
 * sy *= 10;
 * }
 * return (int) (-sy * x - y + sx * y + x);
 * });
 * <p>
 * if (numsArr[0] == 0) {
 * return "0";
 * }
 * StringBuilder ret = new StringBuilder();
 * for (int num : numsArr) {
 * ret.append(num);
 * }
 * return ret.toString();
 * }
 * }
 */
