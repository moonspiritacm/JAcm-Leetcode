package com.moonspirit.acm.leetcode.p0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+标记数组。O(n!) O(n)
 */
class SolutionA {
    private List<List<String>> res;
    private boolean[] col;
    private boolean[] x1;
    private boolean[] x2;
    private String[] dict;

    private void backtrace(int n, int i, List<String> ans) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !x1[i + j] && !x2[i - j + n - 1]) {
                ans.add(dict[j]);
                col[j] = x1[i + j] = x2[i - j + n - 1] = true;
                backtrace(n, i + 1, ans);
                col[j] = x1[i + j] = x2[i - j + n - 1] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        col = new boolean[n];
        x1 = new boolean[n * 2 - 1];
        x2 = new boolean[n * 2 - 1];
        dict = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            sb.replace(i, i + 1, "Q");
            dict[i] = sb.toString();
            sb.replace(i, i + 1, ".");
        }
        backtrace(n, 0, new ArrayList<String>());
        return res;
    }
}
