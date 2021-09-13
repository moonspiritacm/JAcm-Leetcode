package com.moonspirit.acm.leetcode.p0480;

import java.util.PriorityQueue;

class SolutionA {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new double[0];
        }

        int n = nums.length - k + 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);  // 小根堆，存储高半区元素，(k+1)/2
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);  // 大根堆，存储低半区元素，k/2
        int l = (k + 1) / 2;
        for (int i = 0; i < k; i++) {
            if (minHeap.size() <= l) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(nums[i]);
            } else {
                maxHeap.offer(nums[i]);
            }
        }

        double[] res = new double[l];
        res[0] = k % 2 == 1 ? 0.0 + minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
        for (int i = 1; i < l; i++) {
            if (nums[i - 1] >= minHeap.peek()) {
                minHeap.remove(nums[i - 1]);
            } else {
                maxHeap.remove(nums[i - 1]);
            }
            maxHeap.offer(nums[i + k - 1]);
            while(minHeap.size()-maxHeap.size()<k%2) {

            }


        }


    }
}
