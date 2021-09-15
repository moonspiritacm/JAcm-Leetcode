package com.moonspirit.acm.leetcode.p1834;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆。O(nlogn) O(n)
 * <p>
 * 时间复杂度：构造三元组O(n)，数组排序O(nlogn)，堆插入元素O(nlogn)，取堆顶元素O(nlogn)
 * 空间复杂度：数组O(n)，堆O(n)
 */
class SolutionA {
    public int[] getOrder(int[][] tasks) {
        if (tasks == null || tasks.length == 0 || tasks[0].length != 2) {
            return new int[0];
        }

        int n = tasks.length;
        int[][] ts = new int[n][3];
        for (int i = 0; i < n; i++) {
            ts[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(ts, (a, b) -> a[0] - b[0]);  // 入队时间升序

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            } else {
                return a[1] - b[1];
            }
        });  // 耗时小根堆，耗时最小且序号最小者位于堆顶
        int idx = 0;
        int time = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; ) {
            while (idx < n && ts[idx][0] <= time) {
                heap.offer(ts[idx++]);
            }
            if (heap.isEmpty()) {
                time = ts[idx][0];
            } else {
                int[] task = heap.poll();
                res[i++] = task[2];
                time += task[1];
            }
        }
        return res;
    }
}
