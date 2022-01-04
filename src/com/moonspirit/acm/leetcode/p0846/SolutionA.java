package com.moonspirit.acm.leetcode.p0846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SolutionA {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || groupSize <= 0 || groupSize > hand.length) {
            throw new IllegalArgumentException("非法输入");
        }
        if (hand.length % groupSize != 0) {
            return false;
        }

        int n = hand.length;
        Map<Integer, Integer> map = new HashMap<>();  // <数值，频数>二元组
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 数值小根堆
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            heap.offer(num);
        }
        while (!heap.isEmpty()) {
            int num = heap.poll();
            if (map.get(num) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                num++;
                int cnt = map.getOrDefault(num, 0);
                if (cnt == 0) {
                    return false;
                }
                map.put(num, cnt - 1);
            }
        }
        return true;
    }
}
