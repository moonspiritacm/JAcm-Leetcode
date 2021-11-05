package com.moonspirit.acm.leetcode.p0042;

/**
 * 动态规划。O(n) O(n)
 * <p>
 * 计算公式不变，求左、右区间最大值等价于最大前缀问题，使用动态规划求解。
 * l[i] = max(h[i], l[i-1]) 0 -> n-1
 * r[i] = max(h[i], r[i+1]) n-1 -> 0
 */
class SolutionB {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int s = 0;
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = height[0];
        r[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            s += Math.min(l[i], r[i]) - height[i];
        }
        return s;
    }
}
