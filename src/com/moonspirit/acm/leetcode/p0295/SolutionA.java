package com.moonspirit.acm.leetcode.p0295;

import java.util.PriorityQueue;

/**
 * 双堆。O(logn)/O
 */
class MedianFinder {
    PriorityQueue<Integer> lHeap;  // 大根堆，存放左半区间，(k+1)/2，堆顶为中位数（奇数）或中位数之一（偶数）
    PriorityQueue<Integer> rHeap;  // 小根堆，存放右半区间，K/2，堆顶为中位数之一（偶数）
    int size;

    public MedianFinder() {
        this.lHeap = new PriorityQueue<>((a, b) -> b - a);
        this.rHeap = new PriorityQueue<>((a, b) -> a - b);
        this.size = 0;
    }

    public void addNum(int num) {
        size++;

        // 确定当前元素插入位置
        if (lHeap.isEmpty() || num <= lHeap.peek()) {
            lHeap.offer(num);
        } else {
            rHeap.offer(num);
        }

        // 调整双堆规模
        // 右堆->左堆：保证右堆不大于左堆
        while (lHeap.size() < rHeap.size()) {
            lHeap.offer(rHeap.poll());
        }
        // 左堆->右堆：保证左堆不大于右堆+1
        while (lHeap.size() > rHeap.size() + 1) {
            rHeap.offer(lHeap.poll());
        }
    }

    public double findMedian() {
        return size % 2 == 0 ? (lHeap.peek() + rHeap.peek()) / 2.0 : 0.0 + lHeap.peek();
    }
}

时间复杂度：addNum 函数的复杂度为 O(\log{n})O(logn)；findMedian 函数的复杂度为 O(1)O(1)
        空间复杂度：O(n)O(n)

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/gong-shui-san-xie-jing-dian-shu-ju-jie-g-pqy8/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。