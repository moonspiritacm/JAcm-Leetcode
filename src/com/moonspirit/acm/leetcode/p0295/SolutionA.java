package com.moonspirit.acm.leetcode.p0295;

import java.util.PriorityQueue;

/**
 * 双堆。O(logn)/O(1) O(n)
 * <p>
 * 大根堆，存放左半区间，(k+1)/2，堆顶为中位数（奇数）或中位数之一（偶数）
 * 小根堆，存放右半区间，k/2，堆顶为中位数之一（偶数）
 */
class MedianFinderA {
    private PriorityQueue<Integer> lHeap;
    private PriorityQueue<Integer> rHeap;

    public MedianFinderA() {
        lHeap = new PriorityQueue<>((a, b) -> b - a);
        rHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        // 确定当前元素插入的堆
        if (lHeap.isEmpty() || lHeap.peek() >= num) {
            lHeap.offer(num);
        } else {
            rHeap.offer(num);
        }

        // 右堆->左堆：保证右堆不大于左堆
        while (rHeap.size() > lHeap.size()) {
            lHeap.offer(rHeap.poll());
        }
        // 左堆->右堆：保证左堆不大于右堆+1
        while (lHeap.size() > rHeap.size() + 1) {
            rHeap.offer(lHeap.poll());
        }
    }

    public double findMedian() {
        return lHeap.size() == rHeap.size() ? (lHeap.peek() + rHeap.peek()) / 2.0 : 0.0 + lHeap.peek();
    }
}
