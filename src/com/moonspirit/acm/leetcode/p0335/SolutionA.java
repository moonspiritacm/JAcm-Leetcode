package com.moonspirit.acm.leetcode.p0335;

/**
 * 分类讨论。O(n) O(1)
 * <p>
 * 1.第四条边与第一条边相交；
 * 2.第五条边与第一条边相交；
 * 3.第六条边与第一条边相交。
 */
class SolutionA {
    private boolean op1(int[] d, int i) {
        return i >= 3 && d[i] >= d[i - 2] && d[i - 1] <= d[i - 3];
    }

    private boolean op2(int[] d, int i) {
        return i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2];
    }

    private boolean op3(int[] d, int i) {
        return i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] + d[i - 5] >= d[i - 3];
    }

    public boolean isSelfCrossing(int[] distance) {
        if (distance == null || distance.length < 4) {
            return false;
        }

        for (int i = 3; i < distance.length; i++) {
            if (op1(distance, i) || op2(distance, i) || op3(distance, i)) {
                return true;
            }
        }
        return false;
    }
}
