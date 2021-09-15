package com.moonspirit.acm.leetcode.p0502;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 贪心+堆。O((2n+k)logn) O(n)
 * <p>
 * 贪心策略：每次都在所有候选者（未被选择且启动资金不超过当前资金）中选择利润最大的任务，最终取得的总金额最大。
 * 时间复杂度：数组排序O(nlogn)，堆插入元素O(nlogn)，取堆顶元素O(klogn)
 * 空间复杂度：数组O(n)，堆O(n)
 */
class SolutionA {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k <= 0 || profits == null || capital == null || profits.length == 0 || profits.length != capital.length) {
            return w;
        }

        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);  // 启动资金升序

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);  // 利润大根堆，利润最大者位于堆顶
        int idx = 0;
        for (int i = 0; i < k; i++) {
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
