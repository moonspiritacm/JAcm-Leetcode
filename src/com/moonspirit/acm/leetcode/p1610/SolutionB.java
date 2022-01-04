package com.moonspirit.acm.leetcode.p1610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionB {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
}
