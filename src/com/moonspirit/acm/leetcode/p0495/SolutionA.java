package com.moonspirit.acm.leetcode.p0495;

/**
 * 模拟。O(n) O(1)
 */
class SolutionA {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) {
            return 0;
        }

        int res = duration * timeSeries.length;
        int next = 0;
        for (int time : timeSeries) {
            if (time < next) {
                res -= next - time;
            }
            next = time + duration;
        }
        return res;
    }
}
