package com.moonspirit.acm.leetcode.p0384;

import java.util.Random;

/**
 * Knuth-Shuffle。O(n) O(n)
 * <p>
 * 从第一个元素开始，依次向后遍历。
 * 对于编号x的元素，在 [x,n-1] 中随机选择交换，实现原地随机洗牌。
 * <p>
 * new Random().next(x)，返回 [0,x) 范围内的随机整数值。
 */
class SolutionA {
    private int n;
    private int[] nums;
    private Random random = new Random();

    public SolutionA(int[] _nums) {
        n = _nums.length;
        nums = _nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int j = i + random.nextInt(n - i);
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
        }
        return res;
    }
}
