package com.moonspirit.acm.leetcode.p0692;

import java.util.*;

/**
 * 哈希表+全排序。O(n+mlogm) O(2ml)
 * <p>
 * 哈希表统计词频：时间复杂度O(n)，空间复杂度O(ml)
 * 全排序求TopK：时间复杂度O(mlogm)，空间复杂度O(ml)，其中包含结果集O(kl)
 */
class SolutionA {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (String word : map.keySet()) {
            res.add(word);
        }
        Collections.sort(res, (a, b) -> {
            int na = map.get(a);
            int nb = map.get(b);
            if (na == nb) {
                return a.compareTo(b);
            } else {
                return nb - na;
            }
        });  // 频次降序，字典序升序
        return res.subList(0, k);
    }
}
