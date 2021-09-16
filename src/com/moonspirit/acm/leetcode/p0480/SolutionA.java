package com.moonspirit.acm.leetcode.p0480;

import java.util.PriorityQueue;

/**
 * 双堆。O(nk) O(n)
 * <p>
 * 大根堆，存放左半区间，(k+1)/2，堆顶为中位数（奇数）或中位数之一（偶数）
 * 小根堆，存放右半区间，k/2，堆顶为中位数之一（偶数）
 * <p>
 * 整型溢出问题：
 * ①使用减法比较大小时，Integer.MAX_VALUE-Integer.MIN_VALUE会导致溢出，建议使用Integer.compare(a, b)
 * ②使用加法计算中位数时，(a+b)/2.0有溢出风险，(a/2.0+b/2.0)则不会。
 * <p>
 * PriorityQueue的remove方法O(n)：先调用indexOf线性扫描找到下标O(n)，再调用removeAt删除O(logn)。
 */
class SolutionA {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new double[0];
        }

        PriorityQueue<Integer> lHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> rHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int i = 0; i < k; i++) {
            lHeap.offer(nums[i]);
        }
        while (rHeap.size() < k / 2) {
            rHeap.offer(lHeap.poll());
        }

        int n = nums.length - k + 1;
        double[] res = new double[n];
        res[0] = k % 2 == 0 ? lHeap.peek() / 2.0 + rHeap.peek() / 2.0 : 0.0 + lHeap.peek();
        for (int i = 1; i < n; i++) {
            if (nums[i + k - 1] <= lHeap.peek()) {
                lHeap.offer(nums[i + k - 1]);
            } else {
                rHeap.offer(nums[i + k - 1]);
            }
            if (nums[i - 1] <= lHeap.peek()) {
                lHeap.remove(nums[i - 1]);
            } else {
                rHeap.remove(nums[i - 1]);
            }

            while (rHeap.size() > lHeap.size()) {
                lHeap.offer(rHeap.poll());
            }
            while (lHeap.size() > rHeap.size() + 1) {
                rHeap.offer(lHeap.poll());
            }
            res[i] = k % 2 == 0 ? lHeap.peek() / 2.0 + rHeap.peek() / 2.0 : 0.0 + lHeap.peek();
        }
        return res;
    }
}
