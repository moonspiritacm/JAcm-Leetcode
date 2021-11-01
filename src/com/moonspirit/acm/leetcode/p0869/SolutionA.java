package com.moonspirit.acm.leetcode.p0869;

import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 1; i < 1e9 + 7; i *= 2) {
            set.add(i);
        }
    }

    private boolean dfs(int[] nums, int n, int sum, int idx) {
        if (idx == n) {
            return set.contains(sum);
        }

        for (int i = 0; i < n; i++) {
            if (sum == 0 && nums[i] == 0 || nums[i] == -1) {
                continue;
            }

            int num = nums[i];
            nums[i] = -1;
            if (dfs(nums, n, sum * 10 + num, idx + 1)) {
                return true;
            }
            nums[i] = num;
        }
        return false;
    }

    public boolean reorderedPowerOf2(int N) {
        if (N <= 0) {
            return false;
        }

        int n = 0;
        int[] nums = new int[10];
        while (N != 0) {
            nums[n++] = N % 10;
            N /= 10;
        }
        for (int i = n; i < 10; i++) {
            nums[i] = -1;
        }
        return dfs(nums, n, 0, 0);
    }
}
