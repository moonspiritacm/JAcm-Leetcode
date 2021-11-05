package com.moonspirit.acm.leetcode.p0042;

/**
 * 暴力。O(n^2) O(1)
 * <p>
 * 计算每个非边缘点位的最终水量：r[i] = min(max(h[0~i]), max(h[i~n-1])) - h[i]，时间复杂度O(n)
 * 总水量为各个点位水量之和：res = sum(r[i])，总时间复杂度O(n^2)
 */
class SolutionA {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int s = 0;
        int n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int l = height[i];
            int r = height[i];
            for (int j = i - 1; j >= 0; j--) {
                l = Math.max(l, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                r = Math.max(r, height[j]);
            }
            s += Math.min(l, r) - height[i];
        }
        return s;
    }
}
