package com.moonspirit.acm.leetcode.p0295;

import java.util.Map;
import java.util.TreeMap;

/**
 * 桶+有序集合。O(1)/O(C) O(C)
 * <p>
 * 针对数据集中分布的情况，维护长度为C的桶，统计各数出现的次数。
 * 针对少量离群值的情况，在桶两边维护各维护一个有序序列，存储<数字, 个数>二元组。
 * 查找中位数时，首先计算中位数出现在第几位，然后扫描各桶找到答案。
 * <p>
 * 相比于双堆解法，计算效率上没有优势，更多是空间优化。即使在极限数据10^7的情况下，O(logn)仍然低于O(101)计算耗时。
 */
class MedianFinderB {
    private TreeMap<Integer, Integer> left;
    private TreeMap<Integer, Integer> right;
    private int[] nums;
    private int[] cnt;
    private int size;

    public MedianFinderB() {
        left = new TreeMap<>();
        right = new TreeMap<>();
        nums = new int[101];
        cnt = new int[3];
        size = 0;
    }

    public void addNum(int num) {
        if (num >= 0 && num <= 100) {
            nums[num]++;
            cnt[1]++;
        } else if (num < 0) {
            left.put(num, left.getOrDefault(num, 0) + 1);
            cnt[0]++;
        } else {
            right.put(num, right.getOrDefault(num, 0) + 1);
            cnt[2]++;
        }
        size++;
    }

    public double findMedian() {
        return size % 2 == 0 ? (find(size / 2) + find(size / 2 + 1)) / 2.0 : 0.0 + find(size / 2 + 1);
    }

    private int find(int n) {
        if (n <= cnt[0]) {
            for (Map.Entry<Integer, Integer> entry : left.entrySet()) {
                n -= entry.getValue();
                if (n <= 0) {
                    return entry.getKey();
                }
            }
        } else if (n <= cnt[0] + cnt[1]) {
            n -= cnt[0];
            for (int i = 0; i <= 100; i++) {
                n -= nums[i];
                if (n <= 0) {
                    return i;
                }
            }
        } else {
            n -= cnt[0] + cnt[1];
            for (Map.Entry<Integer, Integer> entry : right.entrySet()) {
                n -= entry.getValue();
                if (n <= 0) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}
