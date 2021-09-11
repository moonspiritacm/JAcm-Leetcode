package com.moonspirit.acm.leetcode.p0502;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 贪心+堆。
 *
 * 时间复杂度：数组排序O(nlogn)，堆插入元素O(nlogn)，取堆顶元素O(klogn)
 * 空间复杂度：数组O(n)，堆O(n)
 */
class SolutionA {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k <= 0 || profits == null || capital == null || profits.length == 0 || profits.length != capital.length) {
            return 0;
        }

        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;
        while (k-- > 0) {
            while (idx < n && projects[idx][1] <= w) {
                heap.offer(projects[idx++][0]);
            }
            if (heap.isEmpty()) {
                return w;
            }
            w += heap.poll();
        }
        return w;
    }
}
