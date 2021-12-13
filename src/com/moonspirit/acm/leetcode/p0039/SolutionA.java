package com.moonspirit.acm.leetcode.p0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯+剪枝。
 * <p>
 * 题目要点：
 * ①候选数组无重复元素；
 * ②元素可以被无限制重复选取；
 * ③组合不能重复。
 * <p>
 * 剪枝策略：
 * ①将候选数组从小到大排序，按照顺序依次选取；
 * ②每次只能选取大于等于上一数字的元素，保证组合无重复；
 * ③如果当前元素大于目标元素，其右侧所有元素均不满足要求，直接返回。
 * <p>
 * 时间复杂度：
 * 一般难以准确给出回溯算法的时间复杂度，只能给出不包含剪枝情况的时间复杂度上界。
 * 时间复杂度取决于候选数组的元素特征：如果候选数组元素较大，目标和相对较小，搜索树深度低，时间复杂度小；反之亦然。
 */
class SolutionA {
    private List<List<Integer>> res;
    private List<Integer> ans;

    private void backtrace(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            ans.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }
}
