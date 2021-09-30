package com.moonspirit.acm.leetcode.p0517;

class SolutionA {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return 0;
        }

        int n = machines.length;
        int num = 0;
        for (int machine : machines) {
            num += machine;
        }
        if (num % n != 0) {
            return -1;
        }
        num /= n;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
            if (sum > num * (i + 1)) {
                res = Math.max(res, sum - num * (i + 1));
            } else {
                res = Math.max(res, num * (i + 1) - sum);
            }
        }
        return res;
    }
}
