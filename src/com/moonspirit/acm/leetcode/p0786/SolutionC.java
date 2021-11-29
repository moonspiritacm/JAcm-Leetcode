package com.moonspirit.acm.leetcode.p0786;

/**
 * 二分查找+双指针。O(nlogC) O(1)
 * <p>
 * 目标元素必然落在[0, 1]范围内，并且具有二段性，使用二分法。
 * 如果小于等于当前元素的个数大于等于k，目标元素落在左半区间，right=mid；
 * 如果小于等于当前元素的个数小于k，目标元素落在右半区间，left=mid。
 * 当区间长度小于最小间隔时，返回小于当前元素的最大元素，即为目标元素。
 * <p>
 * 根据数组的有序性，使用双指针计算小于目标元素的个数。
 * 对于分母j，分数随分子i右移而增大，直到大于x，cnt+=i；遍历分母，即可求出小于目标元素的个数。
 * 如果分母j1<j2，i1恰好为使分数不大于x的最大位置，一定有i2>=i1，即每次循环不必从0开始。
 */
class SolutionC {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k < 1 || k > arr.length * (arr.length - 1) / 2) {
            throw new IllegalArgumentException("非法输入");
        }

        double eps = 1e-8;
        double left = 0;
        double right = 1;
        int[] res = new int[]{0, 1};
        while (right - left > eps) {
            double mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 1; j < arr.length; j++) {
                while (1.0 * arr[i + 1] / arr[j] <= mid) {
                    i++;
                }
                if (arr[i] * 1.0 / arr[j] <= mid) {
                    cnt += i + 1;
                }

                if (Math.abs(1.0 * arr[i] / arr[j] - mid) < eps) {
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }

            if (cnt >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return res;
    }
}
