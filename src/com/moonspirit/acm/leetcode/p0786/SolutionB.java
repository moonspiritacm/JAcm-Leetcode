package com.moonspirit.acm.leetcode.p0786;

import java.util.PriorityQueue;

/**
 * 多路归并。O(nlogn+klogn) O(n)
 * <p>
 * 根据数组内元素严格单调递增的特性，将数组分解为n-1个有序序列。问题转化为，对n-1路有序序列进行归并排序，找到第k个元素。
 * arr[0]/arr[1]
 * arr[0]/arr[2]、arr[1]/arr[2]
 * arr[0]/arr[3]、arr[1]/arr[3]、arr[2]/arr[3]
 * arr[0]/arr[4]、arr[1]/arr[4]、arr[2]/arr[4]、arr[3]/arr[4]
 * 构造规模为n-1的小根堆，每次取堆顶元素（第i小元素），加入该序列的下一元素，以此类推。第k次取出的堆顶元素，即为第k小结果。
 */
class SolutionB {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k < 1 || k > arr.length * (arr.length - 1) / 2) {
            throw new IllegalArgumentException("非法输入");
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                Double.compare(1.0 * arr[a[0]] / arr[a[1]], 1.0 * arr[b[0]] / arr[b[1]]));
        for (int i = 1; i < arr.length; i++) {
            minHeap.offer(new int[]{0, i});
        }
        while (k-- > 1) {
            int[] tmp = minHeap.poll();
            if (tmp[1] - tmp[0] > 1) {
                minHeap.offer(new int[]{tmp[0] + 1, tmp[1]});
            }
        }
        int[] tmp = minHeap.poll();
        return new int[]{arr[tmp[0]], arr[tmp[1]]};
    }
}
