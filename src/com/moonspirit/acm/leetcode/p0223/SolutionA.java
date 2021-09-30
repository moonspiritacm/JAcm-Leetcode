package com.moonspirit.acm.leetcode.p0223;

/**
 * 容斥原理。O(1) O(1)
 * <p>
 * 先不考虑重叠情况，计算总数，再减去重复计算数量，保证不重不漏。
 * A∪B∪C=A+B+C-A∩B-B∩C-C∩A+A∩B∩C。
 */
class SolutionA {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int res = (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1);
        int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int y = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (x < 0 || y < 0) {
            return res;
        }
        return res - x * y;
    }
}
