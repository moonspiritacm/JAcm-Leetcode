package com.moonspirit.acm.leetcode.p0846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || groupSize <= 0 || groupSize > hand.length) {
            throw new IllegalArgumentException("非法输入");
        }
        if (hand.length % groupSize != 0) {
            return false;
        }

        int n = hand.length;
        int m = hand.length / groupSize;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            int num = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    num = Math.min(num, entry.getKey());
                }
            }
            map.put(num, map.get(num) - 1);
            for (int j = 1; j < groupSize; j++) {
                num++;
                if (!map.containsKey(num)) {
                    return false;
                }
                map.put(num, map.get(num) - 1);
            }
        }
        return true;
    }
}

