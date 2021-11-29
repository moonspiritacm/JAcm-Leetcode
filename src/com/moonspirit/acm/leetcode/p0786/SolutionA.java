package com.moonspirit.acm.leetcode.p0786;

import java.util.PriorityQueue;

/**
 * 优先队列。O(n^2*logk) O(logk)
 * <p>
 * 构建规模为k的大根堆，堆顶元素为第k小的素数对。
 * 扫描素数对，依次入堆，如果堆内元素超过k个，堆顶元素出堆，保证堆中元素为最小的k个素数对。
 */
class SolutionA {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k < 1 || k > arr.length * (arr.length - 1) / 2) {
            throw new IllegalArgumentException("非法输入");
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(1.0 * b[0] / b[1], 1.0 * a[0] / a[1]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxHeap.offer(new int[]{arr[i], arr[j]});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }
}
