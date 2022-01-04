package com.moonspirit.acm.leetcode.p1610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        if (angle < 0 || angle >= 360 || location == null || location.size() != 2) {
            throw new IllegalArgumentException("非法输入");
        }
        if (points == null || points.size() == 0) {
            return 0;
        }

        int num = 0;
        int max = 0;
        int x = location.get(0);
        int y = location.get(1);
        List<Double> angles = new ArrayList<>();
        for (List<Integer> point : points) {
            int a = point.get(0);
            int b = point.get(1);
            if (x == a && y == b) {
                num++;
            } else {
                angles.add(Math.atan2(b - y, a - x) + Math.PI);
            }
        }
        Collections.sort(angles);



        return 0;
    }
}
