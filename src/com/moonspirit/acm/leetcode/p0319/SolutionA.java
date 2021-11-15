package com.moonspirit.acm.leetcode.p0319;

/**
 * 完全平方数。O(1) O(1)
 * <p>
 * 第i轮改变所有编号为i的倍数的灯泡状态。
 * 编号x的灯泡经过n轮后处于打开状态的充要条件是：灯泡被切换奇数次，即x的约数有奇数个。
 * 约数总是成对出现的，如果m为x的约数，那么x/m一定也是x的约数，满足m*x/m=x。
 * 当且仅当x为完全平方数时，x的约数为奇数个。
 * 最终转化为求[1,n]中完全平方数的个数。
 */
class SolutionA {
    public int bulbSwitch(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法输入");
        }

        return (int) Math.sqrt(n);
    }
}
