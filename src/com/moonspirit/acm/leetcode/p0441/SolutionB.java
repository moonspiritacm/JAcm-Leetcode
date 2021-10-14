package com.moonspirit.acm.leetcode.p0441;

/**
 * 二分查找。O(logn) O(1)
 * <p>
 * n枚硬币最少可以组成1个完整阶梯行，最多可以组成n个完整阶梯行（均在n==1时出现）。
 * <p>
 * 如果n枚硬币能够组成m个完整阶梯行（sum(m)<=n）,那么最后一个完整阶梯行一定出现在右侧（包含m），即[m,r]；
 * 反之，最后一个完整阶梯行一定出现在左侧（不包含m），即[l,m-1]。
 * <p>
 * 当查找范围包含某侧端点时，计算中点时应注意取相反的方向，防止死循环。
 */
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }

        long l = 1;
        long r = n;
        while (l < r) {
            long m = l + (r - l + 1) / 2;
            long num = (1 + m) * m / 2;
            if (num <= n) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return (int) r;
    }
}
