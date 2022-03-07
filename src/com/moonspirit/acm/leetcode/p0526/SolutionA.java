package com.moonspirit.acm.leetcode.p0526;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯。O(n^2+n!) O(n^2)
 */
class SolutionA {
    private List<Set<Integer>> list;
    private boolean[] vis;
    private int res = 0;

    private void backtrace(int i, int n) {
        if (i == n + 1) {
            res++;
            return;
        }

        for (int num : list.get(i - 1)) {
            if (!vis[num]) {
                vis[num] = true;
                backtrace(i + 1, n);
                vis[num] = false;
            }
        }
    }

    public int countArrangement(int n) {
        if (n < 1 || n > 15) {
            throw new IllegalArgumentException("非法输入");
        }

        list = new ArrayList<>();
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    set.add(j);
                }
            }
            list.add(set);
        }
        backtrace(1, n);
        return res;
    }
}
