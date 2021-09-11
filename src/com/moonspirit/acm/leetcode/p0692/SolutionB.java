package com.moonspirit.acm.leetcode.p0692;

import java.util.*;

/**
 * 哈希表+堆。O(n+mlogk) O(ml+kl)
 * <p>
 * 哈希表统计词频：时间复杂度O(n)，空间复杂度O(ml)
 * 小根堆求TopK：时间复杂度O(mlogk)，空间复杂度O(kl)
 */
class SolutionB {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int na = map.get(a);
            int nb = map.get(b);
            if (na == nb) {
                return b.compareTo(a);
            } else {
                return na - nb;
            }
        });  // 词频小根堆
        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
