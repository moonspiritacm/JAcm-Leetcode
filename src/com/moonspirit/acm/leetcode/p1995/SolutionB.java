package com.moonspirit.acm.leetcode.p1995;

import java.util.HashMap;
import java.util.Map;

class SolutionB {
    public int countQuadruplets(int[] nums) {
        if (nums == null || nums.length < 4) {
            throw new IllegalArgumentException("非法输入");
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int c = nums.length - 2; c >= 2; c--) {
            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    int num = nums[a] + nums[b] + nums[c];
                    res += map.getOrDefault(num, 0);
                }
            }
        }
        return res;
    }
}
